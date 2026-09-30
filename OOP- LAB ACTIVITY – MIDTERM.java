import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

class Student {
    private String studentNo;
    private String studentName;
    private Date dateOfBirth;
    private int tariffPoints;
    
    private static int noOfStudents = 0;

    public Student() {
        this.studentNo = "not known";
        this.studentName = "not known";
        try {
            this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995");
        } catch (Exception e) {
            this.dateOfBirth = new Date();
        }
        this.tariffPoints = 20;
        noOfStudents++;
    }

    public Student(String studentNo, String studentName, Date dateOfBirth, int tariffPoints) {
        setStudentNo(studentNo);
        setStudentName(studentName);
        setDateOfBirth(dateOfBirth);
        setTariffPoints(tariffPoints);
        noOfStudents++;
    }

    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) {
        if (studentNo != null && !studentNo.trim().isEmpty()) {
            this.studentNo = studentNo;
        } else {
            this.studentNo = "not known";
        }
    }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) {
        if (studentName != null && !studentName.trim().isEmpty()) {
            this.studentName = studentName;
        } else {
            this.studentName = "not known";
        }
    }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public int getTariffPoints() { return tariffPoints; }
    public void setTariffPoints(int tariffPoints) {
        if (tariffPoints >= 20 && tariffPoints <= 280) {
            this.tariffPoints = tariffPoints;
        } else {
            System.out.println("Invalid tariff points. Must be between 20 and 280. Setting to default (20).");
            this.tariffPoints = 20;
        }
    }

    public static int getNoOfStudents() { return noOfStudents; }

    public void display() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student No: " + studentNo + ", Name: " + studentName + 
                           ", DOB: " + (dateOfBirth != null ? sdf.format(dateOfBirth) : "N/A") + 
                           ", Tariff Points: " + tariffPoints);
    }
}

 class Main2 {

    public static void runProgram1(Scanner sc) {
        double[] arr = new double[10];
        System.out.println("Enter 10 real numbers:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextDouble();
        }

        double sumPos = 0;
        int countPos = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                sumPos += arr[i];
                countPos++;
            }
        }
        double avgPos = (countPos > 0) ? sumPos / countPos : 0;
        System.out.println("Sum of positive numbers: " + sumPos);
        System.out.println("Average of positive numbers: " + avgPos);

        int countNeg = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] < 0) {
                countNeg++;
            }
        }
        System.out.println("Count of negative numbers: " + countNeg);

        double minVal = arr[0];
        for (int i = 1; i < 10; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        System.out.println("Minimum value: " + minVal);
    }

    public static void runProgram2(Scanner sc) {
        int[] arr = new int[8];
        System.out.println("Enter 8 integer numbers:");
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = new int[8];
        int j = 0;
        for (int i = 0; i < 8; i++) {
            boolean isDuplicate = false;
            for (int k = 0; k < j; k++) {
                if (arr[i] == temp[k]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[j++] = arr[i];
            }
        }
        int[] uniqueArr = Arrays.copyOf(temp, j);
        System.out.print("Array after removing duplicates: ");
        for (int val : uniqueArr) {
            System.out.print(val + " ");
        }
        System.out.println();

        if (uniqueArr.length < 2) {
            System.out.println("Cannot find second largest/smallest due to insufficient unique elements.");
            return;
        }

        Arrays.sort(uniqueArr);
        System.out.println("Second Smallest element: " + uniqueArr[1]);
        System.out.println("Second Largest element: " + uniqueArr[uniqueArr.length - 2]);
    }

    public static void runProgram3(Scanner sc) {
        int[] arr = new int[5];
        System.out.print("Enter Data in Array: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Stored Data in Array: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Enter poss. of Element to Delete: ");
        int pos = sc.nextInt();

        if (pos < 1 || pos > 5) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("New data in Array: ");
        for (int i = 0; i < 5; i++) {
            if (i == pos - 1) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void runProgram4(Scanner sc) {
        System.out.print("Enter Size of Array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter any " + size + " elements in Array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();

        for (int val : arr) {
            if (val % 2 == 0) {
                evenList.add(val);
            } else {
                oddList.add(val);
            }
        }

        System.out.print("Even Elements: ");
        for (int val : evenList) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.print("Odd Elements: ");
        for (int val : oddList) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void runProgram5() {
        System.out.println("*");
        System.out.println("A");
        System.out.println("AA*");
        System.out.println("AAA");
    }

    public static void runProgram6() {
        Student s1 = new Student();
        System.out.println("Object 1 (Default Constructor):");
        s1.display();

        try {
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2001");
            Student s2 = new Student("ST101", "John Doe", dob, 150);
            System.out.println("\nObject 2 (Parameterized Constructor):");
            s2.display();
        } catch (Exception e) {
            System.out.println("Date Parsing Error.");
        }

        System.out.println("\nTotal Students created: " + Student.getNoOfStudents());
    }

    public static void runProgram7(Scanner sc) {
        System.out.print("Enter file path (e.g., data.txt): ");
        sc.nextLine(); 
        String filePath = sc.nextLine();

        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";

        String sql = "INSERT INTO students_data (col1, col2, col3) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             BufferedReader reader = new BufferedReader(new FileReader(filePath));
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length >= 3) {
                    preparedStatement.setString(1, data[0]);
                    preparedStatement.setString(2, data[1]);
                    preparedStatement.setString(3, data[2]);
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            System.out.println("Error processing database/file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continueChoice;

        do {
            System.out.println("\nChoose the program you want to run");
            System.out.println("Number 1");
            System.out.println("Number 2");
            System.out.println("Number 3");
            System.out.println("Number 4");
            System.out.println("Number 5");
            System.out.println("Number 6");
            System.out.println("Number 7");
            System.out.print("Enter option (1-7): ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    runProgram1(sc);
                    break;
                case 2:
                    runProgram2(sc);
                    break;
                case 3:
                    runProgram3(sc);
                    break;
                case 4:
                    runProgram4(sc);
                    break;
                case 5:
                    runProgram5();
                    break;
                case 6:
                    runProgram6();
                    break;
                case 7:
                    runProgram7(sc);
                    break;
                default:
                    System.out.println("Invalid Option!");
            }

            System.out.print("Do you want to continue ? Y/N: ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'Y' || continueChoice == 'y');

        sc.close();
        System.out.println("Exiting Program.");
    }
}
