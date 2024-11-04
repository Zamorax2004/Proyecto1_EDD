package proyecto_edd;

public class CustomIterator<E> {
    private CustomList.Node<E> current;

    public CustomIterator(CustomList.Node<E> head) {
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