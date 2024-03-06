public class MyArrayList {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(Object value) {
        ensureCapacity(size + 1);
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}


class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add("Hello");
        list.add("World");

        System.out.println("Size: " + list.size()); // Выводит размер коллекции

        System.out.println("Element at index 0: " + list.get(0)); // Выводит элемент под индексом 0

        list.remove(1); // Удаляет элемент под индексом 1

        System.out.println("Size after removal: " + list.size()); // Выводит размер коллекции после удаления
    }
}
