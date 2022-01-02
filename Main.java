package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {


        char[][] seats = enterSeats();
        int menu = 0;
        do {
            System.out.print("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n> ");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    print(seats);
                    break;
                case 2:
                    buyTicket(seats);
                    break;
                case 3:
                    statistics(seats);
                    break;
                default:
                    System.out.println("\nWrong input!");
                    break;
            }
        }while (menu != 0);

    }

    public static char[][] enterSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        int row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
        int seat = scanner.nextInt();
        char[][] seats = new char[row][seat];
        for (char[] ch : seats) {
            java.util.Arrays.fill(ch, 'S');
        }
        return seats;
    }

    public static void print(char[][] seats) {
        System.out.print("\nCinema:\n  ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void buyTicket(char[][] seats) {
        int row = 0;
        int seat = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter a row number:\n> ");
            row = scanner.nextInt();
            System.out.print("Enter a seat number in that row:\n> ");
            seat = scanner.nextInt();
            if (row > seats.length || seat > seats[0].length) {
            System.out.println("\nWrong input!");
            } else if (seats[row - 1][seat - 1] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
            } else {
                break;
            }
        }while (true);
        seats[row - 1][seat - 1] = 'B';
        System.out.println("\nTicket price: $" +
                (seats.length * seats[0].length <= 60 || row <= seats.length / 2 ? "10" : "8"));
    }
    public static void statistics(char[][] seats) {
        int noTickets = 0;
        int noSeats = 0;
        int income = 0;
        int total = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                noSeats++;
                total += seats.length * seats[0].length <= 60 || i + 1 <= seats.length / 2 ? 10 : 8;
                if (seats[i][j] == 'B') {
                    noTickets ++;
                    income += seats.length * seats[0].length <= 60 || i + 1 <= seats.length / 2 ? 10 : 8;
                }
            }
        }
        double percentage = (double) noTickets / noSeats * 100.0;
        System.out.printf("%nNumber of purchased tickets: %d%n", noTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", income);
        System.out.printf("Total income: $%d%n", total);
    }
}