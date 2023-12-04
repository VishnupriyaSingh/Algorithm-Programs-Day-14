import java.util.ArrayList;
import java.util.List;

public class DSQ8 {
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

    private static List<List<Integer>> findPrimesInRange(int maxRange) {
        List<List<Integer>> primes2D = new ArrayList<>();
        int range = 100;

        for (int i = 0; i <= maxRange; i += range) {
            primes2D.add(new ArrayList<>());
        }

        for (int i = 2; i <= maxRange; i++) {
            if (isPrime(i)) {
                int index = i / range;
                primes2D.get(index).add(i);
            }
        }
        return primes2D;
    }

    public static void main(String[] args) {
        int maxRange = 1000;
        List<List<Integer>> primes2D = findPrimesInRange(maxRange);

        for (int i = 0; i < primes2D.size(); i++) {
            System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": " + primes2D.get(i));
        }
    }
}
