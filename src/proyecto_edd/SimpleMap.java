package proyecto_edd;

public class SimpleMap {
    private String[] keys;
    private String[] values;
    private int size;

    public SimpleMap() {
        keys = new String[100];
        values = new String[100];
        size = 0;
    }

    public void put(String key, String value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public String get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public String[] keySet() {
        String[] result = new String[size];
        System.arraycopy(keys, 0, result, 0, size);
        return result;
    }
}