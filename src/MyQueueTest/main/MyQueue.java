package MyQueueTest.main;

public class MyQueue {
    private final int SIZE;
    private final int[] queue;
    private final int front;
    private int rear;

    public MyQueue(int SIZE) {
        this.SIZE = SIZE;
        queue = new int[SIZE];
        front = 0;
        rear = -1;
    }

    // Überprüft, ob die Warteschlange voll ist
    public boolean isFull() {
        return rear == SIZE - 1;
    }

    // Überprüft, ob die Warteschlange leer ist
    public boolean isEmpty() {
        return rear == -1;
    }

    // Fügt Elemente zur Warteschlange hinzu
    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        queue[++rear] = element;
    }

    // Löscht Element aus der Warteschlange
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int temp = queue[front];

        // Verschieben Sie die verbleibenden Elemente nach vorne
        System.arraycopy(queue, 1, queue, 0, rear--);

        return temp;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return queue[rear];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "MyQueue is empty";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("MyQueue elements from front to rear: ");

        for (int i = front; i <= rear; i++) {
            sb.append(queue[i]);

            if (i < rear) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}