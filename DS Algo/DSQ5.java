import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DSQ5 {
    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        String lowerCaseStr = str.toLowerCase();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            deque.addLast(lowerCaseStr.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        boolean isPalindrome = isPalindrome(input);
        System.out.println("The string \"" + input + "\" is palindrome: " + isPalindrome);
    }
}
