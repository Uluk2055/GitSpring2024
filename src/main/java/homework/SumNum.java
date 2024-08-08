package homework;

import java.util.Scanner;

public class SumNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a two digit number: ");
        int num = scanner.nextInt();
        int first = num / 10;
        int second = num % 10;

        System.out.println("The sum of the digits is: " + (first + second));

    }
}
