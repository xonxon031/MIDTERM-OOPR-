import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Strings and special characters are not allowed.");
            System.out.print("Enter a number: ");
            scanner.next();
        }

        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("It's an even number!");
        } else {
            System.out.println("It's an odd number!");
        }

        scanner.close();
    }
}
