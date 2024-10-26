package proyecto_edd;

public class Lista {
    private Object[] elements;
    private int size;

    public Lista() {
        elements = new Object[10];
        size = 0;
    }

    public void add(Object element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
        System.out.println("Added element: " + element + ", current size: " + size);
    }
    
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null; // Clear the last element
                System.out.println("Removed element: " + element + ", current size: " + size);
                return true;
            }
        }
        System.out.println("Element not found: " + element);
        return false;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.out.println("Accessed element at index: " + index + ", element: " + elements[index]);
        return elements[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        System.out.println("Resizing array, current capacity: " + elements.length);
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
        System.out.println("Resized array, new capacity: " + elements.length);
    }
}