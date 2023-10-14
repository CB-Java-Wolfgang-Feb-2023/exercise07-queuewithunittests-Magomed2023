import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue(5);
    }

    @Test
    void testEnqueueDequeue() {
        assertTrue(queue.isEmpty());
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());
        for (int i = 1; i <= 5; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueueException() {
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        assertThrows(IllegalStateException.class, () -> queue.enqueue(6));
    }

    @Test
    void testDequeueException() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void testGetFrontException() {
        assertThrows(IllegalStateException.class, () -> queue.getFront());
    }

    @Test
    void testGetRearException() {
        assertThrows(IllegalStateException.class, () -> queue.getRear());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testEnqueueParameterized(int value) {
        queue.enqueue(value);
        assertFalse(queue.isEmpty());
        assertEquals(value, queue.getRear());
    }
}