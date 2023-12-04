import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoQ9_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("AlgoQ9_1.txt"));
        String[] words = fileScanner.nextLine().split(",");
        fileScanner.close();

        Arrays.sort(words);

        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = inputScanner.nextLine();
        inputScanner.close();

        int result = binarySearch(words, searchWord);

        if (result == -1) {
            System.out.println("Word not found.");
        } else {
            System.out.println("Word found");
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = value.compareTo(array[mid]);

            if (res == 0)
                return mid;

            if (res > 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}
