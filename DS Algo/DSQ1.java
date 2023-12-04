import java.io.*;
import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedLinkedList<T> {
    Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
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

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            add((T) fileScanner.next());
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

public class DSQ1 {
    public static void main(String[] args) {
        UnorderedLinkedList<String> list = new UnorderedLinkedList<>();
        try {
            list.readFromFile("DSQ1.txt");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a word to search: ");
            String word = scanner.nextLine();

            if (list.contains(word)) {
                list.remove(word);
                System.out.println(word + " removed from the list.");
            } else {
                list.add(word);
                System.out.println(word + " added to the list.");
            }

            list.saveToFile("DSQ1_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
