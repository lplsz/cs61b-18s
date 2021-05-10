package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);

        // Two loops of enqueue dequeue
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }

        assertEquals(0, arb.peek());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, arb.dequeue());
        }

        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, arb.dequeue());
        }
    }

    public void forLoop() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);

        for (Object j: arb) {
            System.out.println((int) j);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public void main(String[] args) {
//        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        forLoop();
    }
} 
