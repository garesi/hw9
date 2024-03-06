public class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private Node[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
        size++;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(Object key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
