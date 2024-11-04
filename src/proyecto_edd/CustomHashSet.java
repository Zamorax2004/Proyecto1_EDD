package proyecto_edd;

public class CustomHashSet<E> extends CustomSet<E> {
    public CustomHashSet() {
        super();
    }

    public CustomHashSet(CustomSet<E> otherSet) {
        super();
        this.addAll(otherSet);
    }
}