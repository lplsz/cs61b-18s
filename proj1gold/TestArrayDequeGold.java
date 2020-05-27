import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void Test() {
        StudentArrayDeque<Integer> L1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> L2 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                L1.addLast(i);
            } else {
                L1.addFirst(i);
            }
        }
    }
}
