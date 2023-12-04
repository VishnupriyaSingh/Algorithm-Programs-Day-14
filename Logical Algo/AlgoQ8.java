import java.util.*;

public class AlgoQ8 {

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static boolean areAnagrams(int n1, int n2) {
        char[] array1 = String.valueOf(n1).toCharArray();
        char[] array2 = String.valueOf(n2).toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    static boolean isPalindrome(int n) {
        int reversed = 0, original = n, remainder;
        while (n != 0) {
            remainder = n % 10;
            reversed = reversed * 10 + remainder;
            n /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 1000;
        List<Integer> primes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        System.out.println("Prime numbers that are anagrams and palindromes in the range 0-1000:");
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j)) && isPalindrome(primes.get(i))) {
                    System.out.println(primes.get(i) + " and " + primes.get(j) + " are anagrammatic primes and "
                            + primes.get(i) + " is a palindrome.");
                }
            }
        }
    }
}
