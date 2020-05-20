public class Palindrome {
    /** Take in a string and create a deque*/
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }
        return L;
    }

    public boolean isPalindrome(String word) {
        Deque L = wordToDeque(word);
        return isPalindromeHelper(L);
    }

    private Boolean isPalindromeHelper(Deque L) {
        if (L.isEmpty() == true || L.size() == 1) return true;
        if (L.removeFirst() == L.removeLast()) return isPalindromeHelper(L);
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return true;
    }
}
