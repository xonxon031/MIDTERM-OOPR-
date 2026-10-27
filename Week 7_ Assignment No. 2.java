import java.util.Scanner;

public class LetterCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = '\0';
        
        while (true) {
            System.out.print("Enter a letter: ");
            String input = scanner.next();
            
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                ch = input.charAt(0);
                break; 
            } else {
                System.out.println("Invalid input! Integers, special characters, or multi-character inputs are not allowed.");
            }
        }
        
        char lowerCh = Character.toLowerCase(ch);
        
        if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
            System.out.println("It's a vowel!");
        } else {
            System.out.println("It's a consonant!");
        }
        
        scanner.close();
    }
}
