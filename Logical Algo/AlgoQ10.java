import java.util.Scanner;

public class AlgoQ10 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter N (where N = 2^n): ");
        int N = scanner.nextInt();
        guessNumber(0, N - 1);
    }

    private static void guessNumber(int low, int high) {
        if (low == high) {
            System.out.println("The number you're thinking of is " + low);
            return;
        }

        int mid = low + (high - low) / 2;
        System.out.print("Is your number greater than or equal to " + mid + "? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();

        if (response.equals("yes")) {
            guessNumber(mid + 1, high);
        } else {
            guessNumber(low, mid);
        }
    }
}
