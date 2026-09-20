import java.util.*;

public class Palindrome {

    // 1. Iterative
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    // 2. Recursive
    static boolean isPalindromeRecursive(String text) {
        return recursive(text, 0, text.length() - 1);
    }

    static boolean recursive(String text, int left, int right) {
        if (left >= right)
            return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return recursive(text, left + 1, right - 1);
    }

    // 3. Array Reversal
    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return text.equals(new String(arr));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " +
                (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));
    }
}