package MyQueueTest.main;

public class Main {
    public static void main(String[] args) {
        // Erstelle ein Objekt der MyQueue-Klasse
        MyQueue queue = new MyQueue(5);

        // Versuche, ein Element aus der Warteschlange zu löschen
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Aktuell ist die Warteschlange leer, daher ist eine Löschung nicht möglich.");
        }

        // Fügt Elemente zur Warteschlange hinzu
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
            System.out.println("Element " + i + " zur Warteschlange hinzugefügt. Front: " + queue.getFront() + ", Rear: " + queue.getRear());
        }

        // Überprüft, ob die Warteschlange voll ist
        if (queue.isFull()) {
            System.out.println("Die Warteschlange ist voll.");
        }

        // Entfernt Elemente, bis sie leer ist
        while (!queue.isEmpty()) {
            System.out.println("Element " + queue.dequeue() + " aus der Warteschlange entfernt. Front: " + (queue.isEmpty() ? "-" : queue.getFront()) + ", Rear: " + (queue.isEmpty() ? "-" : queue.getRear()));
        }

        // Überprüft, ob die Warteschlange leer ist
        if (queue.isEmpty()) {
            System.out.println("Die Warteschlange ist leer.");
        }
    }
}