package homework;

import java.util.Scanner;

public class AreaPerimeterCalc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a width: ");
        double width = scanner.nextDouble();

        System.out.println("Enter a height: ");
        double height = scanner.nextDouble();

        System.out.println("Area is " + width + " * "+ height + " = " + (width * height));
        System.out.println("Perimeter is 2 * (" + width + " + " + height + ") = " + (2 * (width + height )));

    }
}
