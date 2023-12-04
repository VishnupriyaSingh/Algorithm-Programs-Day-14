import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AlgoQ9_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        bubbleSort(numbers);

        System.out.println("Sorted List: " + numbers);
    }

    public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
