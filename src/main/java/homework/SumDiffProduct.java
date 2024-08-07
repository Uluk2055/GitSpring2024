package homework;

import java.util.Scanner;

public class SumDiffProduct {
    public static void main(String[] args) {

        int number1;
        int number2;
        String symbol;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        number1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        number2 = scanner.nextInt();
        System.out.println("Enter  + or - or *  or /");
        symbol = scanner.next();
        if (symbol.equals("+")) {
            System.out.println(number1 + number2);
        } else if (symbol.equals("-")) {
            if (number1 > number2) {
                System.out.println(number1 - number2);
            } else {
                System.out.println(number2 - number1);
            }
        } else if (symbol.equals("*")) {
            System.out.println(number1 * number2);
        } else if (symbol.equals("/")) {
            if (number1 > number2) {
                System.out.println(number1 / number2);
            } else {
                System.out.println(number2 / number1);
            }
        } else {
            System.out.println("Incorrect symbol");
        }
    }
}
