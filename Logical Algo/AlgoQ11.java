import java.util.Arrays;
import java.util.Scanner;

public class AlgoQ11 {
    static class Task implements Comparable<Task> {
        int deadline;
        int duration;

        Task(int deadline, int duration) {
            this.deadline = deadline;
            this.duration = duration;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tasks: ");
        int n = scanner.nextInt();

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter deadline and duration for task " + (i + 1) + ": ");
            int deadline = scanner.nextInt();
            int duration = scanner.nextInt();
            tasks[i] = new Task(deadline, duration);
        }

        Arrays.sort(tasks);

        int currentTime = 0;
        int maxLateness = 0;
        for (int i = 0; i < n; i++) {
            currentTime += tasks[i].duration;
            maxLateness = Math.max(maxLateness, currentTime - tasks[i].deadline);
            System.out.println("Max lateness after scheduling " + (i + 1) + " tasks: " + maxLateness);
        }
    }
}
