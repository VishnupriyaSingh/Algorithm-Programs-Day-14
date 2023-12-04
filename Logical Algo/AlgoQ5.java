public class AlgoQ5 {

    void sort(String arr[], int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);

            merge(arr, lo, mid, hi);
        }
    }

    void merge(String arr[], int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        String L[] = new String[n1];
        String R[] = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[lo + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = lo;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void printArray(String arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        String arr[] = { "Pear", "Apple", "Orange", "Grape", "Banana" };

        System.out.println("Given Array");
        printArray(arr);

        AlgoQ5 ob = new AlgoQ5();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
