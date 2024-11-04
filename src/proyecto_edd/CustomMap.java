package proyecto_edd;

public class CustomMap<K, V>{
    private CustomList<Entry<K, V>> entries;

    public CustomMap() {
        entries = new CustomList<>();
    }

    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        boolean matchesKey(K key) {
            return this.key.equals(key);
        }
    }

    public void put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return entries.size();
    }

    public CustomList<K> keySet() {
        CustomList<K> keys = new CustomList<>();
        for (Entry<K, V> entry : entries) {
            keys.add(entry.key);
        }
        return keys;
    }
    
    public CustomList<Entry<K, V>> entrySet() {
        CustomList<Entry<K, V>> entrySet = new CustomList<>();
        for (Entry<K, V> entry : entries) {
            entrySet.add(entry);
        }
        return entrySet;
    }
    
    public CustomList<V> values() {
        CustomList<V> values = new CustomList<>();
        for (Entry<K, V> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }
    
    public boolean remove(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }
}