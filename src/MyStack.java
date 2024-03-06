public class MyStack {

    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            next = null;
        }
    }
}
