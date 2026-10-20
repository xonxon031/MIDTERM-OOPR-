
import java.util.Scanner;

abstract class Account {
    private String number;
    private double balance;

    Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 ||
            !Double.isFinite(balance + amount)) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        double fee = getFee();
        if (!Double.isFinite(amount) || amount <= 0 ||
            amount > balance || fee > balance - amount) return false;
        balance -= amount + fee;
        return true;
    }

    abstract double getFee();
    abstract String getType();
}

class SavingsAccount extends Account {
    SavingsAccount(double balance) {
        super("SAV-1001", balance);
    }

    double getFee() {
        return 0;
    }

    String getType() {
        return "Savings";
    }
}

class CheckingAccount extends Account {
    CheckingAccount(double balance) {
        super("CHK-2001", balance);
    }

    double getFee() {
        return 10;
    }

    String getType() {
        return "Checking";
    }
}

public class BankingApp {
    static Scanner sc = new Scanner(System.in);

    static double amount(String message, boolean zeroAllowed) {
        while (true) {
            System.out.print(message);
            try {
                double n = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(n) &&
                    (zeroAllowed ? n >= 0 : n > 0)) return n;
            } catch (Exception e) {
            }
            System.out.println("Invalid input! Try again.");
        }
    }

    static int choice() {
        while (true) {
            System.out.print("Choice: ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= 1 && n <= 5) return n;
            } catch (Exception e) {
            }
            System.out.println("Choose from 1 to 5.");
        }
    }

    static void display(Account a) {
        System.out.println("\nAccount: " + a.getType());
        System.out.println("Number: " + a.getNumber());
        System.out.printf("Balance: PHP %.2f%n", a.getBalance());
    }

    public static void main(String[] args) {
        System.out.println("=== OOP BANKING SYSTEM ===");
        double opening = amount("Opening balance: PHP ", true);

        Account savings = new SavingsAccount(opening);
        Account checking = new CheckingAccount(opening);
        Account selected = savings;

        boolean running = true;

        while (running) {
            display(selected);
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Show Balance");
            System.out.println("4. Switch Account\n5. Exit");

            switch (choice()) {
                case 1:
                    double w = amount("Withdraw: PHP ", false);
                    if (selected.withdraw(w)) {
                        System.out.printf("Withdrawal successful! Fee: PHP %.2f%n",
                                selected instanceof CheckingAccount ? 10.0 : 0.0);
                    } else {
                        System.out.println("Failed! Insufficient funds.");
                    }
                    break;

                case 2:
                    double d = amount("Deposit: PHP ", false);
                    System.out.println(selected.deposit(d)
                            ? "Deposit successful!" : "Deposit failed!");
                    break;

                case 3:
                    display(selected);
                    break;

                case 4:
                    selected = selected == savings ? checking : savings;
                    System.out.println("Switched to " + selected.getType());
                    break;

                case 5:
                    running = false;
                    break;
            }

            if (running) {
                System.out.print("Continue? (Y/N): ");
                String answer = sc.nextLine().trim();
                if (answer.equalsIgnoreCase("N")) running = false;
                else if (!answer.equalsIgnoreCase("Y"))
                    System.out.println("Invalid response. Returning to menu.");
            }
        }

        System.out.println("Thank you for using the banking system!");
        sc.close();
    }
}
