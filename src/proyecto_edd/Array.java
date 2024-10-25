package proyecto_edd;

public class Array {
    private Object[] elements;
    private int size;

    public Array() {
        elements = new Object[10]; // Initial capacity
        size = 0;
    }

    public void add(Object element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    public void set(int index, Object element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}