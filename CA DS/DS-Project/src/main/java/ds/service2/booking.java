package ds.service2;

import java.util.ArrayList;

public class booking {
    int table;
    double time;

    ArrayList<booking> arr = new ArrayList<>(); // arrayList for adding new booking objects


    public booking(int table, double time) throws BookingError{
            if (time != 0) {
                this.table = table;
                this.time = time;
                return;
            }
        throw new BookingError("Unsupported Booking Information\n" +
                ". Please correct the Booking Information to be valid");

        }

    public booking() {
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }


    public String showBookings(){
        String bookings = "";
        for (int i = 0; i < arr.size() ; i++) {
            bookings = String.valueOf(arr.get(i));
        }
        return bookings;
    }

    @Override
    public String toString() {
        return "booking{" +
                "table=" + table +
                ", time=" + time +
                '}';
    }
}
