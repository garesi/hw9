public class MyQueue {
    private Object[] queue;
    private int front; // индекс первого элемента в очереди
    private int rear; // индекс последнего элемента в очереди
    private int size; // количество элементов в очереди
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        this.queue = new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void add(Object value) {
        if (size == queue.length) {
            resize();
        }
        rear = (rear + 1) % queue.length; // учитываем кольцевое перемещение
        queue[rear] = value;
        size++;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object removedItem = queue[front];
        front = (front + 1) % queue.length; // учитываем кольцевое перемещение
        size--;
        return removedItem;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Object[] newQueue = new Object[queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}
