package proyecto_edd;

public class CustomMap<K, V> {
    private CustomList<Entry<K, V>> entries;

    public CustomMap() {
        entries = new CustomList<>();
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
}