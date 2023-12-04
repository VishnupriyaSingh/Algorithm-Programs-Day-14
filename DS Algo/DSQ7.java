import java.util.Scanner;

public class DSQ7 {
    private static final int MOD = 1000000007;

    public static int numberOfBST(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = 1; 
        catalan[1] = 1; 

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = (int)((long)catalan[i] + (long)catalan[j] * catalan[i - j - 1] % MOD) % MOD;
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(numberOfBST(n));
        }
    }
}
