package ds.client;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ds.Auth.BearerToken;
import ds.jmDNS.Discovery;
import ds.service2.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;

import static ds.Auth.jwt.getJwt;


public class SmartManagementClient {

    private static SmartManagementGrpc.SmartManagementBlockingStub blockingStub;
    private static SmartManagementGrpc.SmartManagementStub asyncStub;

    private ServiceInfo service1Info;

    public static void main(String[] args) throws InterruptedException {
        // Generating a valid auth token
        String service_name = "SmartManagement";
        String jwt = getJwt(service_name);
        BearerToken token = new BearerToken(jwt);

        // Discover the jmDNS service
        Discovery discovery = new Discovery();
        String service_type = "_smartmanagement_http._tcp.local.";
        discovery.discoverService(service_type);

        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        // Create stubs
        blockingStub = SmartManagementGrpc.newBlockingStub(channel)
                .withCallCredentials(token);

        asyncStub = SmartManagementGrpc.newStub(channel)
                .withCallCredentials(token);

        // Sleep for 1 sec for flow of output
        TimeUnit.SECONDS.sleep(1);
        // Taking userInput

        int choice;
        do {
            System.out.println("SmartManagement");
            System.out.println();
            System.out.println("Please make your choice");
            System.out.println("1: smartTableBooking()");
            System.out.println("2: smartQ()");
            System.out.println("3: smartView()");
            System.out.println("4: Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    smartTableBooking();
                    break;
                case 2:
                    smartQ();
                    break;
                case 3:
                    smartView();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(1);
            }

        } while (choice != 4);
        channel.shutdown().awaitTermination(5000, TimeUnit.MILLISECONDS);
    }

    // RPC Methods

    // Unary
    public static void smartTableBooking() {
        // Prompting user
        Scanner sc = new Scanner(System.in);
        System.out.println("--smartTableBooking--");
        System.out.println();
        System.out.println("Available tables");
        System.out.println("1, 2, 3, 4, 5, 6, 7, 8, 10, 12");
        System.out.println("Please enter your table choice");
        int requestedTable = sc.nextInt();
        System.out.println("Available times");
        System.out.println("13.00, 14.35, 15.00, 16.00, 17.00, 18.00, 19.00");
        System.out.println("Please enter your time choice");
        double requestedTime = sc.nextDouble();

        // Build the request message
        TableRequest request = TableRequest.newBuilder()
                .setTableInput(requestedTable)
                .setTimeInput(requestedTime)
                .build();

        // Send the message via the blocking stub and store the response
        TableResponse response = blockingStub.withDeadlineAfter(15, TimeUnit.SECONDS).smartTableBooking(request);

        // Display the result
        System.out.println("Table: " + response.getTableOutput() + " Time: " + response.getTimeOutput());

    }

    // Client Streaming
    public static void smartQ() {

        StreamObserver<qResponse> responseObserver = new StreamObserver<qResponse>() {

            @Override
            public void onNext(qResponse value) {
                System.out.println(value.getQSuccessful());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("smartQ client-streaming has failed!");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("smartQ client-streaming has completed!");
            }
        };

        // Send the client data here
        StreamObserver<qRequest> requestObserver = asyncStub.withDeadlineAfter(15, TimeUnit.SECONDS).smartQ(responseObserver);
        // deadline

        try {
            // Prompt user
            Scanner sc = new Scanner(System.in);
            System.out.println("--smartQ--");
            System.out.println("Enter your order details");
            String order = sc.nextLine();
            System.out.println("Enter the desired pickup time");
            System.out.println("Pleae enter in the format " + 1300 + " not 13:00");
            int requestedTime = sc.nextInt();
            // Build request
            qRequest request = qRequest.newBuilder()
                    .setQOrder(order)
                    .setTime(requestedTime)
                    .build();

            requestObserver.onNext(request);

            Thread.sleep(5000);

            // End the requests
            requestObserver.onCompleted();

            // Wait for 2 seconds
            Thread.sleep(2000);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Server Streaming
    public static void smartView() {

        // Prompt user
        Scanner sc = new Scanner(System.in);
        System.out.println("--smartView--");

        System.out.println("Please hit enter");
        String userText = sc.nextLine();

        // Build request
        viewRequest request = viewRequest.newBuilder()
                .setBookingsRequest(userText)
                .build();

        StreamObserver<viewResponse> responseObserver = new StreamObserver<viewResponse>() {

            @Override
            public void onNext(viewResponse value) {
                System.out.println(value.getBookingsTotal());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("smartView() Server-streaming has failed!");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("smartView() Server-streaming has completed!");
            }
        };

        // Client sends the request here via the asynchronous stub
        asyncStub.withDeadlineAfter(15, TimeUnit.SECONDS).smartView(request, responseObserver);
        // deadline

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
