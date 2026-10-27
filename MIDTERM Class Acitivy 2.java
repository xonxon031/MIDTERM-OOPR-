import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LibrarySystemConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String userName = getValidName(scanner, "Enter your name:\n");

        LocalDate today = LocalDate.now();
        System.out.println("Welcome " + userName);
        System.out.println("Today's Date: " + today.format(formatter));

        int totalPages = getValidPositiveInt(scanner, "How many pages does the book have?\n");
        int pagesRead = getValidRangeInt(scanner, "How many pages have you read?\n", 0, totalPages);
        
        LocalDate issueDate = getValidDate(scanner, "Enter the issue date (YYYY-MM-DD):\n");
        LocalDate dueDate = getValidDate(scanner, "Enter the due date (YYYY-MM-DD):\n");

        double percentageRead = ((double) pagesRead / totalPages) * 100.0;
        int pagesLeft = totalPages - pagesRead;

        long daysRemaining = java.time.temporal.ChronoUnit.DAYS.between(today, dueDate);

        double pagesPerDayNeeded = 0;
        if (daysRemaining > 0) {
            pagesPerDayNeeded = (double) pagesLeft / daysRemaining;
        }

        System.out.printf("You have read %.0f%% of the book.%n", percentageRead);
        System.out.println("You have " + daysRemaining + " day(s) remaining to return the book.");
        System.out.printf("You still have %d page(s) left and you should read %.0f pages a day%n", pagesLeft, pagesPerDayNeeded);

        scanner.close();
    }

    private static String getValidName(Scanner scanner, String prompt) {
        String name;
        while (true) {
            System.out.print(prompt);
            name = scanner.nextLine().trim();
            if (name.matches("^[a-zA-Z\\s]+$") && !name.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter letters only.");
            }
        }
        return name;
    }

    private static int getValidPositiveInt(Scanner scanner, String prompt) {
        return getValidMinInt(scanner, prompt, 1);
    }

    private static int getValidMinInt(Scanner scanner, String prompt, int minVal) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= minVal) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
        return value;
    }

    private static int getValidRangeInt(Scanner scanner, String prompt, int minVal, int maxVal) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= minVal && value <= maxVal) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
        return value;
    }

    private static LocalDate getValidDate(Scanner scanner, String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String input = scanner.next();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
        return date;
    }
}
