package proyecto_edd;

public class Map<K, V> {
    private Entry<K, V>[] entries;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public Map() {
        entries = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i].setValue(value);
                return;
            }
        }
        if (size == entries.length) {
            resize();
        }
        entries[size++] = new Entry<>(key, value);
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                V value = entries[i].getValue();
                entries[i] = entries[--size];
                entries[size] = null;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[i] = null;
        }
        size = 0;
    }

    private void resize() {
        Entry<K, V>[] newEntries = new Entry[entries.length * 2];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}