package cinema;

public class Cinema {

    public static void main(String[] args) {
        char[][] seatingPlan = enterSeats();
        print(seatingPlan);
    }

    public static char[][] enterSeats() {
        final int rows = 7;
        final int seats = 8;
        char[][] seatingPlan = new char[rows][seats];
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                seatingPlan[i][j] = 'S';
            }
        }
        return seatingPlan;
    }

    public static void print(char seatingPlan[][]) {
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < seatingPlan.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
