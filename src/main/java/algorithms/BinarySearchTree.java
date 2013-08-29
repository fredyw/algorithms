package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private class Node {
        private int size;
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        
        public Node(int size, Key key, Value value) {
            this.size = size;
            this.key = key;
            this.value = value;
        }
    }
    
    private Node root;
    
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(0, key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
            node.size += 1;
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
            node.size += 1;
        } else {
            node.value = value; // replace the old value
        }
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
        return (root == null) ? 0: root.size;
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
