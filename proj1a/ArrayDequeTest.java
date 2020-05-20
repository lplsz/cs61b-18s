import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    /** Performs some basic linked list tests. */

    /* Utility method for printing out empty checks. */
    @Test
    public void checkEmpty() {
        ArrayDeque<String> L = new ArrayDeque<>();
        assertEquals(true, L.isEmpty());
    }

    /* Utility method for printing out empty checks. */
    @Test
    public void checkSize() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        assertEquals(3, L.size());
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("3");
        assertEquals(1, L.size());
        L.addFirst("2");
        assertEquals("2", L.get(0));
        L.addFirst("1");
        assertEquals("3", L.get(2));
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("1");
        assertEquals(1, L.size());
        L.removeFirst();
        assertEquals(0, L.size());
        L.addFirst("1");
        L.addFirst("0");
        L.addLast("2");
        assertEquals("2", L.get(2));
        assertEquals("2", L.removeLast());
        assertEquals("1", L.get(1));
    }

}
