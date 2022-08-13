package ds.service2;

import ds.Auth.AuthorisationServerInterceptor;
import ds.Auth.Constants;
import ds.jmDNS.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;


public class SmartManagementServer extends SmartManagementGrpc.SmartManagementImplBase {


    public static void main(String[] args) throws InterruptedException, IOException {
        SmartManagementServer service1 = new SmartManagementServer();
        Registration reg = new Registration();
        reg.registerService("_smartmanagement_http._tcp.local.", "SmartManagement", 50052, "service for Smart Management operations");
        int port = 50052;
        try {
            // Create new server
            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .intercept(new AuthorisationServerInterceptor())
                    .build()
                    .start();

            System.out.println("SmartManagement started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Unary
    @Override
    public void smartTableBooking(TableRequest request, StreamObserver<TableResponse> responseObserver) {

        String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
        System.out.println("Processing request from " + clientId);
        // Get input
        System.out.println("-smartTableBooking-");
        int requestedTable = request.getTableInput();
        double requestedTime = request.getTimeInput();
        // pretend fake available booking times and tables
        int[] availableTables = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12};
        double[] availableTimes = {13.00, 14.35, 15.00, 16.00, 17.00, 18.00, 19.00};
        // Build response
        TableResponse.Builder response = TableResponse.newBuilder();

        for (int i: availableTables){
            if(i == requestedTable){
                response.setTableOutput("Table is available");
                System.out.println("Table booking successful");
                break;
            } else {
                response.setTableOutput("Sorry that table is unavailable");
                System.out.println("Table booking unsuccessful");
                break;
            }

        }

        for (double i: availableTimes){
            if(i == requestedTime){
                response.setTimeOutput(requestedTime);
                System.out.println("Time is available");
                break;
            } else {
                response.setTimeOutput(0);
                System.out.println("Time is unavailable");
                break;
            }

        }

        //creating booking instance
        booking booking = new booking(requestedTable, requestedTime);
        // storing booking object in arrayList
        booking.arr.add(booking);

        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Client Streaming
    @Override
    public StreamObserver<qRequest> smartQ(StreamObserver<qResponse> responseObserver) {
        return new StreamObserver<qRequest>() {

            @Override
            public void onNext(qRequest value) {
                String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
                System.out.println("Processing request from " + clientId);

                String order = value.getQOrder();
                int time = value.getTime();
                Order orderDetails = new Order();
                Order orderObj = new Order(order, time);
                System.out.println("Order is: " + order + " and the Time requested is: " + time);
                orderDetails.arr.add(orderObj);

            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                // Build response
                qResponse response = qResponse.newBuilder()
                        .setQSuccessful("Order has been accepted. See you soon!")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

        };
    }


    // Server streaming
    @Override
    public void smartView(viewRequest request, StreamObserver<viewResponse> responseObserver) {

        String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
        System.out.println("Processing request from " + clientId);

        System.out.println("-smartView-");

        // Build response
        viewResponse.Builder response = viewResponse.newBuilder();
        response.setBookingsTotal(String.valueOf(booking.arr.toString()));

        // call showBookings()
        booking.showBookings();
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

