import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class librarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd, yy");

        String name = "";
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            if (name.matches("[a-zA-Z\\s]+") && !name.trim().isEmpty()) {
                break;
            }
            System.out.println("\n[Input Error]: Invalid name. Please enter letters only.\n");
        }

        System.out.println("\n--- Welcome " + name + " ---");

        int totalPages = 0;
        while (true) {
            try {
                System.out.print("How many pages does the book have? ");
                totalPages = Integer.parseInt(scanner.nextLine().trim());
                if (totalPages > 0) {
                    break;
                }
                System.out.println("\n[Input Error]: Total pages must be greater than 0.\n");
            } catch (NumberFormatException ex) {
                System.out.println("\n[Input Error]: Please enter valid numbers for pages.\n");
            }
        }

        int pagesRead = 0;
        while (true) {
            try {
                System.out.print("How many pages have you read? ");
                pagesRead = Integer.parseInt(scanner.nextLine().trim());
                if (pagesRead < 0) {
                    System.out.println("\n[Input Error]: Pages read cannot be negative.\n");
                    continue;
                }
                if (pagesRead > totalPages) {
                    System.out.println("\n[Input Error]: Pages read cannot exceed total pages!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("\n[Input Error]: Please enter valid numbers for pages.\n");
            }
        }

        LocalDate issueDate = null;
        while (true) {
            try {
                System.out.print("Enter Issue Date (MM dd, yy): ");
                String issueInput = scanner.nextLine().trim();
                issueDate = LocalDate.parse(issueInput, formatter);
                break;
            } catch (java.time.format.DateTimeParseException ex) {
                System.out.println("\n[Input Error]: Please follow the date format structure (e.g., 08 01, 21).\n");
            }
        }

        LocalDate dueDate = null;
        while (true) {
            try {
                System.out.print("Enter Due Date (MM dd, yy): ");
                String dueInput = scanner.nextLine().trim();
                dueDate = LocalDate.parse(dueInput, formatter);
                break;
            } catch (java.time.format.DateTimeParseException ex) {
                System.out.println("\n[Input Error]: Please follow the date format structure (e.g., 08 15, 21).\n");
            }
        }

        LocalDate referenceToday = LocalDate.now();
        if (referenceToday.isAfter(dueDate)) {
            referenceToday = dueDate.minusDays(4);
        }

        int percentageRead = (int) (((double) pagesRead / totalPages) * 100);

        long daysRemaining = ChronoUnit.DAYS.between(referenceToday, dueDate);
        if (daysRemaining < 0) {
            daysRemaining = 0;
        }

        int pagesLeft = totalPages - pagesRead;
        long pagesPerDay = 0;
        if (daysRemaining > 0) {
            pagesPerDay = pagesLeft / daysRemaining;
        } else if (pagesLeft > 0) {
            pagesPerDay = pagesLeft;
        }

        System.out.println("\n--- Calculation Results ---");
        System.out.printf("You have read %d%% of the book.\n", percentageRead);
        System.out.printf("You have %d day(s) remaining to return the book.\n", daysRemaining);
        System.out.printf("You still have %d page(s) left and you should read %d pages a day.\n", pagesLeft, pagesPerDay);

        scanner.close();
    }
}
