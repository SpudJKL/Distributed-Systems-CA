package ds.service2;

import java.util.ArrayList;

public class Order {
    String orderDetails;
    int time;

    ArrayList<Order> arr = new ArrayList<>();

    public Order(String orderDetails, int time) {
        this.orderDetails = orderDetails;
        this.time = time;
    }

    public Order() {
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDetails='" + orderDetails + '\'' +
                ", time=" + time +
                '}';
    }
}
