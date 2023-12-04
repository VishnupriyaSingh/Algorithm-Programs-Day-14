public class DSQ10 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class Stack {
        Node top;

        public void push(int data) {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        public int pop() {
            if (top == null)
                throw new RuntimeException("Stack is empty");
            int data = top.data;
            top = top.next;
            return data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
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
        Stack stack = new Stack();

        for (int i = 2; i < primes.length; i++) {
            primes[i] = isPrime(i);
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + 1; j < primes.length; j++) {
                    if (primes[j] && areAnagrams(i, j)) {
                        stack.push(i);
                        stack.push(j);
                        primes[i] = primes[j] = false;
                        break;
                    }
                }
            }
        }

        System.out.println("Prime Anagrams in Reverse Order:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
