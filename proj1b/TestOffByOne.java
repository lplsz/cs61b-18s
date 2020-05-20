import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('z', 'y'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('d', 'a'));
        assertFalse(offByOne.equalChars('D', 'A'));
        assertTrue(offByOne.equalChars('Z', 'Y'));
        assertTrue(offByOne.equalChars('Z', 'Y'));
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
