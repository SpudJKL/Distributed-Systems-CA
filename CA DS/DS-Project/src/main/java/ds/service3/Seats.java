package ds.service3;

import java.util.Arrays;

public class Seats {
    public static char[][] fill() {

        int rows = 4;
        int cols = 4;
        int totalSeats = cols * rows;
        char[][] seats = new char[cols][rows];
        for (char[] row : seats) {
            Arrays.fill(row, 'A');

        }
         return seats;
    }

    public Seats() {
    }


    public static void showSeats(char[][] seats) {
        System.out.println("Seats:");
        for (int i = 0; i <= seats[0].length; i++) {
            for (int j =0; j<= seats.length; j++ ) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" "+ j);
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
    }

    public static void addseat(int row, int col, char[][] seat){
        int Row=row;
        int Col=col;
        seat[Col - 1][Row - 1] = 'T';

    }
}







