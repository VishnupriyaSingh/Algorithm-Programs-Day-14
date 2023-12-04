import java.io.*;
import java.util.Scanner;

class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class OrderedList<T extends Comparable<T>> {
    private Node<T> head;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null || head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public boolean remove(T data) {
        if (head == null)
            return false;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextInt()) {
            insert((T) Integer.valueOf(fileScanner.nextInt()));
        }
        fileScanner.close();
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        Node<T> current = head;
        while (current != null) {
            writer.write(current.data.toString());
            writer.newLine();
            current = current.next;
        }
        writer.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}

public class DSQ2 {
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        try {
            list.readFromFile("DSQ2.txt");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int number = scanner.nextInt();

            if (list.remove(number)) {
                System.out.println(number + " removed from the list.");
            } else {
                list.insert(number);
                System.out.println(number + " inserted into the list.");
            }

            list.saveToFile("DSQ2_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
