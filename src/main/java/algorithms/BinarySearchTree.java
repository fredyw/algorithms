package algorithms;

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
        if (node.key.compareTo(key) < 0) {
            node.left = put(node.left, key, value);
            node.size += 1;
        } else if (node.key.compareTo(key) > 0) {
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
        if (node.key.compareTo(key) < 0) {
            return get(node.left, key);
        } else if (node.key.compareTo(key) > 0) {
            return get(node.right, key);
        }
        return node;
    }
    
    public int getSize() {
        return (root == null) ? 0: root.size;
    }
}
