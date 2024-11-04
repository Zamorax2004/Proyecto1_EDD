package proyecto_edd;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private ArrayList<Entry<K, V>>[] table;
    private int size;

    public HashMap() {
        table = new ArrayList[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public V put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }
        for (int i = 0; i < table[index].size(); i++) {
            Entry<K, V> entry = table[index].get(i);
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
        return null;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        for (int i = 0; i < table[index].size(); i++) {
            Entry<K, V> entry = table[index].get(i);
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        for (int i = 0; i < table[index].size(); i++) {
            Entry<K, V> entry = table[index].get(i);
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                table[index].remove(i);
                size--;
                return value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        ArrayList<Entry<K, V>>[] oldTable = table;
        table = new ArrayList[oldTable.length * 2];
        size = 0;
        for (ArrayList<Entry<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    Entry<K, V> entry = bucket.get(i);
                    put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private static class Entry<K, V> {
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