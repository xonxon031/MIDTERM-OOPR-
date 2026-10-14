import java.util.Scanner;

public class vowelcosonantchecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char ch = scanner.next().charAt(0);
        
        char lowerCh = Character.toLowerCase(ch);
        
        if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
            System.out.println("It's a vowel!");
        } else if ((lowerCh >= 'a' && lowerCh <= 'z')) {
            System.out.println("It's a consonant!");
        }
        
        scanner.close();
    }
}
