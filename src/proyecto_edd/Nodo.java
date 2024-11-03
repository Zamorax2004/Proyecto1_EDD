package proyecto_edd;

public class Nodo {
    String data;
    Nodo next;
    Nodo neighbor;

    public Nodo(String data) {
        this.data = data;
        this.next = null;
        this.neighbor = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void addNeighbor(Nodo neighbor) {
        if (this.neighbor == null) {
            this.neighbor = neighbor;
        } else {
            Nodo temp = this.neighbor;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(neighbor);
        }
    }
}