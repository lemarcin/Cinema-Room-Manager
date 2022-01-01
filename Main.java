package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        char[][] seatingPlan = enterSeats();
        int menu = 0;
        do {
            System.out.print("\n1. Show the seats\n2. Buy a ticket\n0. Exit\n> ");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    print(seatingPlan);
                    break;
                case 2:
                    buyTicket(seatingPlan);
            }
        }while (menu != 0);

    }

    public static char[][] enterSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
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

    public static void buyTicket(char seatingPlan[][]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a row number:\n> ");
        int row = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n> ");
        int seat = scanner.nextInt();
        seatingPlan[row - 1][seat - 1] = 'B';
        System.out.println("\nTicket price: $" +
                (seatingPlan.length * seatingPlan[0].length <= 60 || row <= seatingPlan.length / 2 ? "10" : "8"));
    }
}