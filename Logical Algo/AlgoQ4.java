import java.util.Scanner;
import java.util.ArrayList;

public class AlgoQ4 {

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

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
