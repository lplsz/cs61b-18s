import static org.junit.Assert.*;
import org.junit.Test;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	@Test
	public void checkEmpty() {
		LinkedListDeque<String> L = new LinkedListDeque<>();
		assertEquals(true, L.isEmpty());
	}

	/* Utility method for printing out empty checks. */
	@Test
	public void checkSize() {
		LinkedListDeque<Integer> L = new LinkedListDeque<>();
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
		LinkedListDeque<String> L = new LinkedListDeque<>();
		assertEquals(true, L.isEmpty());
		L.addLast("front");
		assertEquals(1, L.size());
		L.addFirst("First");
		assertEquals("First", L.getRecursive(0));
		L.addFirst("Last");
		assertEquals("front", L.getRecursive(2));
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	@Test
	public void addRemoveTest() {
		LinkedListDeque<String> L = new LinkedListDeque<>();
		assertEquals(true, L.isEmpty());
		L.addLast("1");
		assertEquals(1, L.size());
		L.removeFirst();
		assertEquals(0, L.size());
		L.addFirst("1");
		L.addFirst("0");
		L.addLast("2");
		assertEquals("2", L.getRecursive(2));
		assertEquals("2", L.removeLast());
		assertEquals("1", L.getRecursive(1));
	}

} 