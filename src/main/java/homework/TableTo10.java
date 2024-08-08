package homework;

import java.util.Scanner;

public class TableTo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        int result;

        for (int i = 1; i <= 10; i++){
            result = num * i;
            System.out.println(num + " * " + i + " = " + result);
        }

    }
}
