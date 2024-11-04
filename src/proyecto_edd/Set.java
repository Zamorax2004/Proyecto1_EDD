package proyecto_edd;

public class Set<T> {
    private Node<T>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public Set() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int getBucketIndex(T data) {
        return data.hashCode() % buckets.length;
    }

    public boolean add(T data) {
        int index = getBucketIndex(data);
        Node<T> current = buckets[index];
        while (current != null) {
            if (current.data.equals(data)) {
                return false;
            }
            current = current.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        return true;
    }

    public boolean contains(T data) {
        int index = getBucketIndex(data);
        Node<T> current = buckets[index];
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(T data) {
        int index = getBucketIndex(data);
        Node<T> current = buckets[index];
        Node<T> prev = null;
        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    // Additional methods like iterator can be implemented here
}