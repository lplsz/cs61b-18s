public class Palindrome {
    /**
     * Take in a string and create a deque
     */
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
        if (L.isEmpty() || L.size() == 1) {
            return true;
        }
        if (L.removeFirst() == L.removeLast()) {
            return isPalindromeHelper(L);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque L = wordToDeque(word);
        return isPalindromeOverloadHelper(L, cc);
    }

    private Boolean isPalindromeOverloadHelper(Deque L, CharacterComparator cc) {
        if (L.isEmpty() || L.size() == 1) {
            return true;
        }
        if (cc.equalChars((char) L.removeFirst(), (char) L.removeLast())) {
            return isPalindromeOverloadHelper(L, cc);
        }
        return false;
    }
}
