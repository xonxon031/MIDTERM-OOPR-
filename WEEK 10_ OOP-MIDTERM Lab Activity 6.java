
import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;

public class machineprobs {
    static Scanner sc = new Scanner(System.in);

    static String input(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    static int number(String msg, int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(input(msg));
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException e) {}
            System.out.println("Invalid input. Try again.");
        }
    }

    static double amount(String msg, boolean zeroAllowed) {
        while (true) {
            try {
                double n = Double.parseDouble(input(msg));
                if (Double.isFinite(n) && (zeroAllowed ? n >= 0 : n > 0))
                    return n;
            } catch (NumberFormatException e) {}
            System.out.println("Invalid amount. Try again.");
        }
    }

    static String required(String msg) {
        String s;
        do {
            s = input(msg);
            if (s.isEmpty()) System.out.println("This field cannot be empty.");
        } while (s.isEmpty());
        return s;
    }

    static boolean again() {
        while (true) {
            String s = input("Do you want to continue? (Y/N): ");
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Enter Y or N only.");
        }
    }

    static void program1() {
        System.out.println("\nWelcome!");
        double balance = amount("Enter your balance: ", true);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Exit");

            int choice = number("Choice: ", 1, 3);

            if (choice == 1) {
                double a = amount("How much amount you want to withdraw from your account? Amount: ", false);
                if (a > balance) {
                    System.out.println("Insufficient balance.");
                } else {
                    balance = Math.round((balance - a) * 100.0) / 100.0;
                    System.out.printf("Your new balance is: %.2f%n", balance);
                }
            } else if (choice == 2) {
                double a = amount("How much amount you want to deposit in your account? Amount: ", false);
                balance = Math.round((balance + a) * 100.0) / 100.0;
                System.out.printf("Your new balance is: %.2f%n", balance);
            } else {
                System.out.println("Thank you for using the system!");
                return;
            }

            if (!again()) {
                System.out.println("Thank you for using the system!");
                return;
            }
        }
    }

    static class Date {
        int year, month, day;

        Date(String label) {
            while (true) {
                try {
                    LocalDate d = LocalDate.parse(input(label + " (YYYY-MM-DD): "));
                    year = d.getYear();
                    month = d.getMonthValue();
                    day = d.getDayOfMonth();
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date. Use YYYY-MM-DD.");
                }
            }
        }

        public String toString() {
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }

    static class Patient {
        String name, disease;
        Date admission, discharge;
        int age;

        void enter() {
            name = required("Name of patient: ");
            admission = new Date("Date of admission");
            disease = required("Disease: ");

            while (true) {
                discharge = new Date("Date of discharge");
                LocalDate a = LocalDate.of(admission.year, admission.month, admission.day);
                LocalDate d = LocalDate.of(discharge.year, discharge.month, discharge.day);
                if (!d.isBefore(a)) break;
                System.out.println("Discharge cannot be before admission.");
            }

            age = number("Age: ", 0, 130);
        }

        public String toString() {
            return "Name: " + name +
                   "\nAdmission: " + admission +
                   "\nDisease: " + disease +
                   "\nDischarge: " + discharge +
                   "\nAge: " + age;
        }
    }

    static void program2() {
        ArrayList<Patient> patients = new ArrayList<>();

        while (true) {
            System.out.println("\n--- HOSPITAL PATIENT DATABASE ---");
            System.out.println("1. Insert New Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Display Pediatric Patients");
            System.out.println("4. Exit");

            int choice = number("Choice: ", 1, 4);

            if (choice == 1) {
                Patient p = new Patient();
                p.enter();
                patients.add(p);
                System.out.println("Patient added successfully.");
            } else if (choice == 2 || choice == 3) {
                boolean found = false;
                for (Patient p : patients) {
                    if (choice == 2 || p.age < 12) {
                        System.out.println("\n--------------------");
                        System.out.println(p);
                        found = true;
                    }
                }
                if (!found) System.out.println("No matching patients found.");
            } else {
                return;
            }

            if (!again()) return;
        }
    }

    static class Professor {
        String name;
        double salary;

        Professor(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String toString() {
            return "Name: " + name + ", Salary: " + String.format("%.2f", salary);
        }
    }

    static class Dean extends Professor {
        String department;

        Dean(String name, String department, double salary) {
            super(name, salary);
            this.department = department;
        }

        public String toString() {
            return "Status, Rank: Dean, Name: " + name +
                   ", Department: " + department +
                   ", Salary: " + String.format("%.0f", salary);
        }
    }

    static class Executive extends Dean {
        Executive(String name, String department, double salary) {
            super(name, department, salary);
        }

        public String toString() {
            return "Status, Rank: Executive, Name: " + name +
                   ", Department: " + department +
                   ", Salary: " + String.format("%.0f", salary);
        }
    }

    static void program3() {
        System.out.println("\n--- DEAN INFORMATION ---");
        String deanName = required("Dean's name: ");
        String deanDepartment = required("Department: ");
        double deanSalary = amount("Salary: ", true);

        Dean d = new Dean(deanName, deanDepartment, deanSalary);
        System.out.println("\n" + d);
        System.out.println("-----------------------------");

        System.out.println("\n--- EXECUTIVE INFORMATION ---");
        String execName = required("Executive's name: ");
        String execDepartment = required("Department: ");
        double execSalary = amount("Salary: ", true);

        Executive e = new Executive(execName, execDepartment, execSalary);
        System.out.println("\n" + e);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Banking System");
            System.out.println("2. Hospital Patient Database");
            System.out.println("3. Professor, Dean and Executive");
            System.out.println("4. Exit");

            int choice = number("Choose a program: ", 1, 4);

            switch (choice) {
                case 1:
                    program1();
                    break;
                case 2:
                    program2();
                    break;
                case 3:
                    program3();
                    break;
                case 4:
                    System.out.println("Program terminated. Goodbye!");
                    sc.close();
                    return;
            }

            if (!again()) {
                System.out.println("Program terminated. Goodbye!");
                sc.close();
                return;
            }
        }
    }
}
