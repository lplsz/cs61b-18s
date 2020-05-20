public class OffByN implements CharacterComparator {
    private int offAmount;

    public OffByN(int N) {
        offAmount = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (int) x == (int) y + offAmount || (int) x == (int) y - offAmount;
    }
}
