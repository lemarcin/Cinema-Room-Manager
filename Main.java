package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        char[][] seatingPlan = enterSeats();
        print(seatingPlan);
        enterSeat(seatingPlan);
        print(seatingPlan);
    }

    public static char[][] enterSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seats = scanner.nextInt();
        char[][] seatingPlan = new char[rows][seats];
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                seatingPlan[i][j] = 'S';
            }
        }
        return seatingPlan;
    }

    public static void print(char seatingPlan[][]) {
        System.out.print("\nCinema:\n  ");
        for (int i = 0; i < seatingPlan[0].length; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < seatingPlan.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void enterSeat(char seatingPlan[][]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        System.out.print("> ");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        System.out.print("> ");
        int seat = scanner.nextInt();
        seatingPlan[row - 1][seat - 1] = 'B';
        System.out.println("\nTicket price: $" + (seatingPlan.length * seatingPlan[0].length <= 60 ? "10" :
                row <= seatingPlan.length / 2 ? "10" : "8"));
    }
}