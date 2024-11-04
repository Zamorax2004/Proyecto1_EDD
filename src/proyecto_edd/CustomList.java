package proyecto_edd;

public class CustomList<E>{
    private Node<E> head;
    private int size;

    public static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public CustomList() {
        head = null;
        size = 0;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(E data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public CustomIterator<E> iterator() {
        return new CustomIterator<>(head);
    }

    public static class CustomIterator<E>{
        private Node<E> current;

        CustomIterator(Node<E> head) {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}