import java.util.HashMap;
import java.util.Scanner;

public class AllInOneProgram {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       JAVA PROGRAMS - CONSOLIDATED OUTPUT        ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Odd Numbers (1-100) ---");
        System.out.println("The Odd Numbers are:");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("--- 2. Sum of Odd Numbers (1-100) ---");
        int sumOdd = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sumOdd = sumOdd + i;
            }
        }
        System.out.println("The Sum Of 100 Odd Numbers are:" + sumOdd + "\n");

        System.out.println("--- 3. Count of Odd Numbers (1-100) ---");
        int countOdd = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                countOdd++;
            }
        }
        System.out.println("The Count Of Odd Numbers are:" + countOdd + "\n");

        System.out.println("--- 4. Sum of First N Numbers ---");
        int sumN = 0;
        int nVal = 10;
        for (int i = 1; i <= nVal; i++) {
            sumN = sumN + i;
        }
        System.out.println("The Sum Of " + nVal + " Numbers are:" + sumN + "\n");

        System.out.println("--- 5. Sum of Digits ---");
        int numDigits = 251025, remDigits = 0, sumDigits = 0, tempDigits;
        tempDigits = numDigits;
        while (numDigits > 0) {
            remDigits = numDigits % 10;
            sumDigits = sumDigits + remDigits;
            numDigits = numDigits / 10;
        }
        System.out.println("Sum of Digits of " + tempDigits + " is " + sumDigits + "\n");

        System.out.println("--- 6. Electric Bill Calculation ---");
        int units = 123;
        int bill = 0;
        if (units > 100) {
            if (units >= 200) {
                if (units > 300) {
                    bill = units * 8;
                } else {
                    bill = units * 6;
                }
            } else {
                bill = units * 5;
            }
        } else {
            bill = units * 2;
        }
        System.out.println("CHENNAI ELECTRICITY LTD, CHENNAI");
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill: " + bill + "\n");

        System.out.println("--- 7. Armstrong Number Check ---");
        int armN = 153, armArg = armN, armSum = 0, armR;
        int tempArm = armN;
        while (tempArm > 0) {
            armR = tempArm % 10;
            armSum = armSum + (armR * armR * armR);
            tempArm = tempArm / 10;
        }
        if (armArg == armSum) {
            System.out.println("Given number is armstrong number: " + armArg);
        } else {
            System.out.println("Given number is not armstrong number: " + armArg);
        }
        System.out.println();

        System.out.println("--- 8. Armstrong Numbers from 1 to 1000 ---");
        System.out.print("Armstrong numbers from 1 to 1000: ");
        for (int i = 1; i <= 1000; i++) {
            int numLimit = i;
            int currentSum = 0;
            while (numLimit > 0) {
                int r = numLimit % 10;
                currentSum = currentSum + (r * r * r);
                numLimit = numLimit / 10;
            }
            if (currentSum == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("--- 9. Palindrome Number Check ---");
        int palNum = 121, palCopy, palR, palRev = 0;
        palCopy = palNum;
        while (palNum > 0) {
            palR = palNum % 10;
            palRev = palRev * 10 + palR;
            palNum = palNum / 10;
        }
        if (palRev == palCopy) {
            System.out.println("The given no is palindrome " + palRev);
        } else {
            System.out.println("The given no is not palindrome " + palRev);
        }
        System.out.println();

        System.out.println("--- 10. Palindrome Numbers Upto N (50) ---");
        System.out.print("Palindrome numbers from 1 to 50: ");
        int limitPal = 50;
        for (int i = 1; i <= limitPal; i++) {
            int tempP = i;
            int revP = 0;
            while (tempP > 0) {
                int b = tempP % 10;
                revP = revP * 10 + b;
                tempP = tempP / 10;
            }
            if (revP == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("--- 11. Prime Numbers (1-100) ---");
        System.out.println("Prime numbers from 1 to 100 are:");
        for (int i = 1; i <= 100; i++) {
            int counter = 0;
            for (int numP = i; numP >= 1; numP--) {
                if (i % numP == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("--- 12. Floyd's Triangle (4 Rows) ---");
        int rows = 4;
        int countF = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(countF + " ");
                countF++;
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("--- 13. Volume of Cube ---");
        int side = 5;
        float volume = side * side * side;
        System.out.println("Volume of Cube:" + volume);
        System.out.println();

        System.out.println("--- 14. Reverse Number ---");
        int revNumVar = 0, numOriginal = 1234, numTemp = numOriginal;
        while (numTemp > 0) {
            int rem = numTemp % 10;
            revNumVar = rem + (revNumVar * 10);
            numTemp = numTemp / 10;
        }
        System.out.println("Number = " + numOriginal);
        System.out.println("Reverse = " + revNumVar);
        System.out.println();

        System.out.println("--- 15. Array Min & Max ---");
        int[] arrSample = { 23, 34, 13, 64, 72, 90, 10, 15, 9, 27 };
        int min = arrSample[0];
        int max = arrSample[0];
        for (int i = 1; i < arrSample.length; i++) {
            if (arrSample[i] > max) {
                max = arrSample[i];
            }
            if (arrSample[i] < min) {
                min = arrSample[i];
            }
        }
        System.out.println("Largest Number in a given array is: " + max);
        System.out.println("Smallest Number in a given array is : " + min);
        System.out.println();

        System.out.println("--- 16. Word Count in String ---");
        String strW = "welcome to candid java tutorial";
        int wordCount = 1;
        for (int i = 0; i < strW.length() - 1; i++) {
            if ((strW.charAt(i) == ' ') && (strW.charAt(i + 1) != ' ')) {
                wordCount++;
            }
        }
        System.out.println("Number of words in a string " + wordCount);
        System.out.println("\n==================================================");
        System.out.println("          PROGRAM EXECUTION COMPLETED             ");
        System.out.println("==================================================");
    }
}
