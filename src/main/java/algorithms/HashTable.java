package algorithms;

import java.util.LinkedList;

public class HashTable<Key, Value> {
    private class KeyValue {
        private Key key;
        private Value value;

        public KeyValue(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KeyValue>[] keyValues;
    private int n;
    private int size;

    public HashTable() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    private HashTable(int n) {
        this.n = n;
        this.keyValues = new LinkedList[n];
        for (int i = 0; i < keyValues.length; i++) {
            keyValues[i] = new LinkedList<KeyValue>();
        }
    }

    public void put(Key key, Value value) {
        LinkedList<KeyValue> ll = keyValues[getIndex(key)];
        for (KeyValue kv : ll) {
            if (kv.key.equals(key)) {
                kv.value = value;
                return;
            }
        }
        size++;
        ll.addFirst(new KeyValue(key, value));
    }

    public Value get(Key key) {
        LinkedList<KeyValue> ll = keyValues[getIndex(key)];
        for (KeyValue kv : ll) {
            if (kv.key.equals(key)) {
                return kv.value;
            }
        }
        return null;
    }

    private int getIndex(Key key) {
        return (key.hashCode() & 0x7fffffff) % n;
    }

    public int getSize() {
        return size;
    }
}
