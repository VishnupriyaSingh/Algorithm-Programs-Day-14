import java.util.LinkedList;
import java.util.Scanner;

class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.pollFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}

class Customer {
    enum TransactionType {
        DEPOSIT, WITHDRAW
    }

    private TransactionType transactionType;
    private int amount;

    public Customer(TransactionType type, int amount) {
        this.transactionType = type;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }
}

public class DSQ4 {
    private Queue<Customer> customerQueue = new Queue<>();
    private int cashBalance;

    public DSQ4(int initialCashBalance) {
        this.cashBalance = initialCashBalance;
    }

    public void addCustomer(Customer customer) {
        customerQueue.enqueue(customer);
    }

    public void processCustomer() {
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.dequeue();
            switch (customer.getTransactionType()) {
                case DEPOSIT:
                    cashBalance += customer.getAmount();
                    break;
                case WITHDRAW:
                    if (cashBalance >= customer.getAmount()) {
                        cashBalance -= customer.getAmount();
                    } else {
                        System.out.println("Insufficient funds for withdrawal.");
                    }
                    break;
            }
        }
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public static void main(String[] args) {
        DSQ4 counter = new DSQ4(10000);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of customers:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Customer " + (i + 1) + ": Deposit or Withdraw (D/W)?");
            char transactionType = scanner.next().charAt(0);
            System.out.println("Enter amount:");
            int amount = scanner.nextInt();

            Customer customer = new Customer(
                    (transactionType == 'D' ? Customer.TransactionType.DEPOSIT : Customer.TransactionType.WITHDRAW),
                    amount);
            counter.addCustomer(customer);
        }

        counter.processCustomer();
        System.out.println("Cash balance at the counter: " + counter.getCashBalance());
    }
}
