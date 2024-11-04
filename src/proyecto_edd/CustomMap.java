package proyecto_edd;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CustomMapDeserializer.class)
public class CustomMap<K, V> {
    private CustomList<Entry<K, V>> entries = new CustomList<>();

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

    @JsonValue
    public CustomList<Entry<K, V>> getEntries() {
        return entries;
    }

    @JsonAnySetter
    public void putEntry(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    @JsonIgnore
    public int size() {
        return entries.size();
    }

    @JsonIgnore
    public boolean containsKey(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @JsonIgnore
    public boolean remove(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.matchesKey(key)) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public CustomList<K> keySet() {
        CustomList<K> keys = new CustomList<>();
        for (Entry<K, V> entry : entries) {
            keys.add(entry.key);
        }
        return keys;
    }

    @JsonIgnore
    public CustomList<Entry<K, V>> entrySet() {
        return entries;
    }

    @JsonIgnore
    public CustomList<V> values() {
        CustomList<V> values = new CustomList<>();
        for (Entry<K, V> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }
}