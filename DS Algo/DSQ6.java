import java.io.*;
import java.util.Scanner;

class OrderedLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public boolean remove(int data) {
        if (head == null) return false;
        if (head.data == data) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class HashTable {
    OrderedLinkedList[] table;

    HashTable(int size) {
        table = new OrderedLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new OrderedLinkedList();
        }
    }

    private int hashFunction(int key) {
        return key % 11;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        table[index].insertSorted(key);
    }

    public void delete(int key) {
        int index = hashFunction(key);
        if (!table[index].remove(key)) {
            insert(key);
        }
    }

    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Slot " + i + ": ");
            table[i].printList();
            System.out.println();
        }
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (OrderedLinkedList list : table) {
            OrderedLinkedList.Node current = list.head;
            while (current != null) {
                writer.write(Integer.toString(current.data));
                writer.newLine();
                current = current.next;
            }
        }
        writer.close();
    }

    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextInt()) {
            insert(fileScanner.nextInt());
        }
        fileScanner.close();
    }
}

public class DSQ6 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        try {
            hashTable.readFromFile("DSQ6.txt");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number to search:");
            int number = scanner.nextInt();

            hashTable.delete(number);

            hashTable.saveToFile("DSQ6_output.txt");
            hashTable.displayTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
