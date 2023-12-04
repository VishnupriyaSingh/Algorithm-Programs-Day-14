import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSQ9 {
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams(int number1, int number2) {
        char[] num1Chars = String.valueOf(number1).toCharArray();
        char[] num2Chars = String.valueOf(number2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }

    private static List<List<Integer>>[] findPrimesAndCategorize(int maxRange) {
        List<Integer> allPrimes = new ArrayList<>();
        for (int i = 2; i <= maxRange; i++) {
            if (isPrime(i)) {
                allPrimes.add(i);
            }
        }

        List<List<Integer>> primesAnagrams = new ArrayList<>();
        List<List<Integer>> primesNonAnagrams = new ArrayList<>();
        for (int i = 0; i <= maxRange / 100; i++) {
            primesAnagrams.add(new ArrayList<>());
            primesNonAnagrams.add(new ArrayList<>());
        }

        for (int prime : allPrimes) {
            boolean isAnagram = false;
            for (int otherPrime : allPrimes) {
                if (prime != otherPrime && areAnagrams(prime, otherPrime)) {
                    isAnagram = true;
                    break;
                }
            }
            int index = prime / 100;
            if (isAnagram) {
                primesAnagrams.get(index).add(prime);
            } else {
                primesNonAnagrams.get(index).add(prime);
            }
        }

        return new List[]{primesAnagrams, primesNonAnagrams};
    }

    public static void main(String[] args) {
        int maxRange = 1000;
        List<List<Integer>>[] result = findPrimesAndCategorize(maxRange);

        List<List<Integer>> anagrams = result[0];
        List<List<Integer>> nonAnagrams = result[1];

        System.out.println("Prime Anagrams:");
        for (int i = 0; i < anagrams.size(); i++) {
            System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": " + anagrams.get(i));
        }

        System.out.println("\nPrime Non-Anagrams:");
        for (int i = 0; i < nonAnagrams.size(); i++) {
            System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": " + nonAnagrams.get(i));
        }
    }
}
