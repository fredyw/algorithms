package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie<T> {
    private class Node {
        private char character;
        private T value;
        private Map<Character, Node> children = new HashMap<>();

        public Node(char c) {
            character = c;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Node [character=");
            builder.append(character);
            builder.append(", value=");
            builder.append(value);
            builder.append(", children=");
            builder.append(children);
            builder.append("]");
            return builder.toString();
        }
    }

    private int size;
    private Map<Character, Node> root = new HashMap<>();

    public void put(String key, T value) {
        char c = key.charAt(0);
        Node n = null;
        if (!root.containsKey(c)) {
            n = new Node(c);
            root.put(c, n);
        } else {
            n = root.get(c);
        }
        put(n, key, value, 0);
    }

    private void put(Node node, String key, T value, int idx) {
        if (idx == key.length() - 1) {
            size++;
            node.value = value;
            return;
        }
        idx++;
        char c = key.charAt(idx);
        Node child = null;
        if (!node.children.containsKey(c)) {
            child = new Node(c);
            node.children.put(c, child);
        } else {
            child = node.children.get(c);
        }
        put(child, key, value, idx);
    }

    public T get(String key) {
        char c = key.charAt(0);
        if (!root.containsKey(c)) {
            return null;
        }
        Node node = root.get(c);
        return get(node, key, 0);
    }

    private T get(Node node, String key, int idx) {
        if (node == null) {
            return null;
        }
        if (idx == key.length() - 1) {
            return node.value;
        }
        idx++;
        char c = key.charAt(idx);
        Node child = node.children.get(c);
        return get(child, key, idx);
    }

    public Set<String> keys(String prefix) {
        Set<String> keys = new HashSet<>();
        char c = prefix.charAt(0);
        if (!root.containsKey(c)) {
            return keys;
        }
        Node node = root.get(c);
        keys(node, prefix, 0, keys);
        return keys;
    }

    private void keys(Node node, String prefix, int idx, Set<String> keys) {
        if (node == null) {
            return;
        }
        if (idx == prefix.length() - 1) {
            // once we reach here, we've already found the node
            // the rest is just to traverse all the child nodes
            traverse(node, prefix, prefix, keys);
            return;
        }
        idx++;
        char c = prefix.charAt(idx);
        Node child = node.children.get(c);
        keys(child, prefix, idx, keys);
    }

    private void traverse(Node node, String prefix, String accu, Set<String> keys) {
        if (node.value != null) {
            keys.add(accu);
        }

        for (Map.Entry<Character, Node> e : node.children.entrySet()) {
            traverse(e.getValue(), prefix, accu + e.getKey(), keys);
        }
    }

    public int getSize() {
        return size;
    }
}
