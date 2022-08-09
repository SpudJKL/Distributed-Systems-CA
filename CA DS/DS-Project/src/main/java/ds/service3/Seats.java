package ds.service3;

import java.util.Arrays;

public class Seats {
    static int rows = 7;
    static int cols = 7;
    int totalSeats = cols * rows;
    static char[][] seats = new char[cols][rows];

    public Seats() {
    }

    public static char[][] fill() {
        // create seats
        int rows = 7;
        int cols = 7;
        int totalSeats = cols * rows;
        char[][] seats = new char[cols][rows];
        for (char[] row : seats) {
            Arrays.fill(row, 'S');
        }
        return seats;
    }



    public static String showSeats() {
        System.out.println("Seats View");
        for (int i = 0; i <= seats[0].length; i++) {
            for (int j = 0; j <= seats.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + j);
                    }
                } else {
                    if (j == 0) {
                        System.out.print(i);
                    } else {
                        System.out.print(" " + seats[j - 1][i - 1]);
                    }
                }
            }
            System.out.print("\n");
        }
        return null;
    }

    public static void addseat(int row, int col){
        int Row=row;
        int Col=col;
        char [][] seat =  fill();
        seat[Col - 1][Row - 1] = 'X';

    }
}
