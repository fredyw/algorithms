package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BalancedSearchTree<Key extends Comparable<Key>, Value> {
    private static enum Color {
        RED, BLACK
    }
    
    private class Node {
        private int size;
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private Color color;
        
        public Node(int size, Key key, Value value, Color color) {
            this.size = size;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
    
    private Node root;
    
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = Color.BLACK;
    }
    
    private Node flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        return node;
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Color.RED;
        x.size = h.size;
        h.size = 1 + getSize(h.left) + getSize(h.right);
        return x;
    }
    
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Color.RED;
        x.size = h.size;
        h.size = 1 + getSize(h.left) + getSize(h.right);
        return x;
    }
    
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }
    
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(1, key, value, Color.RED);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // replace the old value
        }
        
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            node = flipColors(node);
        }
        node.size = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }
    
    public Value get(Key key) {
        Node n = get(root, key);
        if (n == null) {
            return null;
        }
        return n.value;
    }
    
    private Node get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return get(node.right, key);
        }
        return node;
    }
    
    public int getSize() {
        return getSize(root);
    }
    
    private int getSize(Node n) {
        return (n == null) ? 0 : n.size;
    }
    
    public List<Value> get(Key lo, Key hi) {
        List<Value> values = new ArrayList<>();
        get(root, lo, hi, values);
        return values;
    }
    
    private void get(Node node, Key lo, Key hi, List<Value> values) {
        if (node == null) {
            return;
        }
        int cmpLo = lo.compareTo(node.key);
        int cmpHi = hi.compareTo(node.key);
        if (cmpLo < 0) {
            get(node.left, lo, hi, values);
        }
        if (cmpHi > 0) {
            get(node.right, lo, hi, values);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            values.add(node.value);
        }
    }
}
