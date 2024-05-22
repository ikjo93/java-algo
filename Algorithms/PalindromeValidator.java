public class PalindromeValidator {

    public boolean isPalindrome(int number) {
        String s = String.valueOf(number);
        int length = s.length();
        int mid = length / 2;

        for (int i = 0; i <= mid; i++) {
            char start = s.charAt(i);
            char end = s.charAt(length - 1 - i);
            if (start != end) {
                return false;
            }
        }

        return true;
    }
}
