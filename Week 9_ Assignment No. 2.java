import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            int number = 0;
            
            while (true) {
                System.out.print("Enter a number from 1-10: ");
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number >= 1 && number <= 10) {
                        break; 
                    } else {
                        System.out.println("Invalid Number! Please enter a number strictly between 1 and 10.");
                    }
                } else {
                    System.out.println("Invalid input! Strings, decimals, and special characters are not allowed.");
                    scanner.next(); 
                }
            }

            switch (number) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                case 10:
                    System.out.println("Ten");
                    break;
            }

            while (true) {
                System.out.print("Again? y/n: ");
                String inputStr = scanner.next();
                if (inputStr.length() == 1) {
                    choice = Character.toLowerCase(inputStr.charAt(0));
                    if (choice == 'y' || choice == 'n') {
                        break; 
                    }
                }
                System.out.println("Invalid input! Please enter only 'y' or 'n'.");
            }

        } while (choice != 'n');

        System.out.println("Exiting…..");
        scanner.close();
    }
}
