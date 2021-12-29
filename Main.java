package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seats = scanner.nextInt();
        System.out.println("Total income:");
        if (rows * seats <= 60) {
            System.out.println("$" + rows * seats * 10);
        } else {
            System.out.println("$" + (seats * (rows / 2 * 10 + (rows - rows / 2) * 8)));
        }
    }
}