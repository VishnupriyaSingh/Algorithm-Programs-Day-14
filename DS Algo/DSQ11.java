public class DSQ11 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static class Queue {
        Node front, rear;

        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public int dequeue() {
            if (front == null) throw new RuntimeException("Queue is empty");
            int data = front.data;
            front = front.next;
            if (front == null) rear = null;
            return data;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static boolean areAnagrams(int number1, int number2) {
        char[] num1Chars = String.valueOf(number1).toCharArray();
        char[] num2Chars = String.valueOf(number2).toCharArray();
        java.util.Arrays.sort(num1Chars);
        java.util.Arrays.sort(num2Chars);
        return java.util.Arrays.equals(num1Chars, num2Chars);
    }

    public static void main(String[] args) {
        boolean[] primes = new boolean[1001];
        Queue queue = new Queue();

        for (int i = 2; i < primes.length; i++) {
            primes[i] = isPrime(i);
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + 1; j < primes.length; j++) {
                    if (primes[j] && areAnagrams(i, j)) {
                        queue.enqueue(i);
                        queue.enqueue(j);
                        // Mark these primes as added to avoid repetition
                        primes[i] = primes[j] = false;
                        break;
                    }
                }
            }
        }

        System.out.println("Prime Anagrams from Queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
