package proyecto_edd;

public class HashSet<T> {
    private ArrayList<T>[] table;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public HashSet() {
        table = new ArrayList[DEFAULT_CAPACITY];
    }

    private int hash(T key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public boolean add(T key) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ArrayList<>();
        } else {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).equals(key)) {
                    return false;
                }
            }
        }
        table[index].add(key);
        size++;
        return true;
    }

    public boolean contains(T key) {
        int index = hash(key);
        if (table[index] == null) {
            return false;
        }
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T key) {
        int index = hash(key);
        if (table[index] == null) {
            return false;
        }
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).equals(key)) {
                table[index].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void resize() {
        ArrayList<T>[] oldTable = table;
        table = new ArrayList[oldTable.length * 2];
        size = 0;
        for (ArrayList<T> bucket : oldTable) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    add(bucket.get(i));
                }
            }
        }
    }
}