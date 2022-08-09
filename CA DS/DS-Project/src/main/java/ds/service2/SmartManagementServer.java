package ds.service2;

import ds.jmDNS.Registration;
import ds.service1.SmartLightingServer;
import ds.service1.autoLightsResponse;
import ds.service1.lightMusicResponse;
import ds.service2.Service2Impl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class SmartManagementServer extends SmartManagementGrpc.SmartManagementImplBase {

    public static void main(String[] args) throws InterruptedException, IOException {
        SmartManagementServer service1 = new SmartManagementServer();
        Registration resService = new Registration();
        Properties prop = resService.getProperties("Management");
        resService.registerService(prop);
        int port = 50052;
        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
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
    public void smartTableBooking(TableRequest request, StreamObserver<TableResponse> responseObserver) throws BookingError {
        System.out.println("-smartTableBooking-");
        // take input and store
        int requestedTable = request.getTableInput();
        double requestedTime = request.getTimeInput();
        // pretend fake available booking and tables times
        int [] availableTables = {1,2,3,4,5,6,7,8,10,12};
        double [] availableTimes = {13.00, 14.35, 15.00, 16.00, 17.00, 18.00, 19.00};
        // create response builder
        TableResponse.Builder response = TableResponse.newBuilder();
        for (int i = 0; i < availableTables.length; i++) {
            if (requestedTable == availableTables[i]){
                response.setTableOutput("Table is available");
                System.out.println("Table booking successful");
            }
                else if (requestedTable != availableTables[i]) {
                response.setTableOutput("Sorry that table is unavailable");
                System.out.println("Table booking unsuccessful");
            }
        }
        for (int i = 0; i < availableTimes.length; i++) {
            if (requestedTime == availableTimes[i]) {
                response.setTimeOutput(requestedTime);
                System.out.println("Time is available");
            } else if (requestedTime != availableTimes[i]) {
                response.setTimeOutput(0);
                System.out.println("Time is unavailable");
            }
        }
        //creating booking instance
        booking booking = new booking(requestedTable, requestedTime);
        // storing booking object in arrayList
        booking.arr.add(booking);
        // build response
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Client Streaming
    @Override
    public StreamObserver<qRequest> smartQ(StreamObserver<qResponse> responseObserver) {
        return super.smartQ(responseObserver);
    }

    @Override
    public void smartView(viewRequest request, StreamObserver<viewResponse> responseObserver) {
        System.out.println("-smartView-");
        booking booking = new booking();
        viewResponse.Builder response = viewResponse.newBuilder();
        response.setBookingsTotal(booking.showBookings());
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    }
}
