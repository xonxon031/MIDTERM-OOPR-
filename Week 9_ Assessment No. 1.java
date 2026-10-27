import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            
            if (name.matches("^[a-zA-Z\\s]+$")) {
                break; 
            } else {
                System.out.println("Invalid input! Names cannot contain numbers, special characters, or be empty. Try again.");
            }
        }
        
        int i = 0;
        while (i < 5) {
            System.out.println(name); 
            i++;
        }
        
        scanner.close();
    }
}
