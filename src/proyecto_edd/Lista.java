package proyecto_edd;

public class Lista {
    private Nodo head;

    // Constructor
    public Lista() {
        head = null;
    }

    // Metodo para añadir un objeto a la lista
    public void add(String data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = newNode;
        } else {
            Nodo temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Añadido: " + data);
    }

    // Metodo para remover un objeto de la lista
    public boolean remove(String data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            System.out.println("Removed element: " + data);
            return true;
        }

        Nodo temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Removed element: " + data);
            return true;
        }

        System.out.println("Element not found: " + data);
        return false;
    }

    // Funcion que revisa si la lista contiene un elemento especifico
    public boolean contains(String data) {
        Nodo temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Retorna un elemento en una posicion especifica de la lista
    public String get(int index) {
        int count = 0;
        Nodo temp = head;
        while (temp != null) {
            if (count == index) {
                System.out.println("Accessed element at index: " + index + ", element: " + temp.data);
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    // Retorna el numero de elementos en la lista
    public int size() {
        int count = 0;
        Nodo temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}