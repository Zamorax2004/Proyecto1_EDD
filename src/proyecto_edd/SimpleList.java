package proyecto_edd;

public class SimpleList {
    private Object[] elements;
    private int size;

    public SimpleList() {
        elements = new Object[100];
        size = 0;
    }

    public void add(Object element) {
        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    public Object get(int index) {
        if (index < size) {
            return elements[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }
}