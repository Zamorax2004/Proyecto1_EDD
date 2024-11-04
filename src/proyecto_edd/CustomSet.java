package proyecto_edd;

public class CustomSet<E> {
    private CustomList<E> list;

    public CustomSet() {
        list = new CustomList<>();
    }

    public void add(E data) {
        if (!list.contains(data)) {
            list.add(data);
        }
    }

    public boolean remove(E data) {
        return list.remove(data);
    }

    public boolean contains(E data) {
        return list.contains(data);
    }
    
    public int size() {
        return list.size();
    }
    public void addAll(CustomSet<E> otherSet) {
        for (E data : otherSet.list) {
            this.add(data);
        }
    }
    
    public boolean containsAll(CustomSet<E> otherSet) {
        for (E data : otherSet.list) {
            if (!this.contains(data)) {
                return false;
            }
        }
        return true;
    }

    public void removeAll(CustomSet<E> otherSet) {
        for (E data : otherSet.list) {
            this.remove(data);
        }
    }
}