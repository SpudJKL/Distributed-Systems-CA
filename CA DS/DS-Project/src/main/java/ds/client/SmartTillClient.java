package ds.client;

import ds.Auth.BearerToken;
import ds.jmDNS.Discovery;

import ds.service3.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.ServiceInfo;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static ds.Auth.jwt.getJwt;

public class SmartTillClient {
    private static SmartTillGrpc.SmartTillBlockingStub blockingStub;
    private static SmartTillGrpc.SmartTillStub asyncStub;

    private ServiceInfo service1Info;

    public static void main(String[] args) throws InterruptedException {

        // Generating a valid auth token
        String service_name = "SmartTill";
        String jwt = getJwt(service_name);
        BearerToken token = new BearerToken(jwt);

        // Discover the jmDNS service
        Discovery discovery = new Discovery();
        String service_type = "_smarttill_http._tcp.local.";
        discovery.discoverService(service_type);

        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        // Create stubs
        blockingStub = SmartTillGrpc.newBlockingStub(channel)
                .withCallCredentials(token);

        asyncStub = SmartTillGrpc.newStub(channel)
                .withCallCredentials(token);

        // Sleep for 1 sec for flow of output
        TimeUnit.SECONDS.sleep(1);
        // taking userInput

        int choice;
        do {
            System.out.println("SmartTill");
            System.out.println();
            System.out.println("Please make your choice");
            System.out.println("1: smartTill()");
            System.out.println("2: seatManager()");
            System.out.println("3: Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1: smartTill();
                    break;
                case 2: seatManager();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(1);
            }

        } while (choice != 3);
        channel.shutdown().awaitTermination(5000, TimeUnit.MILLISECONDS);
    }

    // RPC Methods

    // Bi-Directional
    public static void smartTill() {
        StreamObserver<tillResponse> responseObserver = new StreamObserver<tillResponse>() {

            @Override
            public void onNext(tillResponse value) {
                System.out.println(value.getTotalOrdersOutput());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("smartTill() bidirectional-streaming has failed!");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("smartTill() bidirectional-streaming has finished");
            }

        };

        // Client sends the requests here via the asynchronous stub
        StreamObserver<tillRequest> requestObserver = asyncStub.withDeadlineAfter(15, TimeUnit.SECONDS).smartTill(responseObserver);
        // deadline
        try {
            // Taking userInput
            Scanner sc = new Scanner(System.in);
            System.out.println("--smartTill--");
            System.out.println("Enter order details e.g Chicken curry etc");
            String orderDetails = sc.nextLine();

            int col = 0;
            do {
                System.out.println("Enter column");
                if (sc.hasNext()) {
                    col = sc.nextInt();
                } else {
                    sc.next();
                    System.out.print("Incorrect input provided! There is only 4 columns");
                }
            } while (!(col >= 1 & col <= 4));


            int row = 0;
            do {
                System.out.println("Enter row");
                if (sc.hasNext()) {
                    row = sc.nextInt();
                } else {
                    sc.next();
                    System.out.print("Incorrect input provided! There is only 4 rows");
                }
            } while (!(row >= 1 & row <= 4));


            // Build request
            tillRequest request = tillRequest.newBuilder()
                    .setOrderInput(orderDetails)
                    .setSeatCol(col)
                    .setSeatRow(row)
                    .build();

            requestObserver.onNext(request);

            // End the requests
            requestObserver.onCompleted();

            // Sleep for a bit
            Thread.sleep(new Random().nextInt(1000) + 500);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Unary
    public static void seatManager() {
        // Prompting user
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("seatManager");
        System.out.println("Please press enter");
        String userInput = sc.nextLine();


        // Build the request message
        seatRequest request = seatRequest.newBuilder()
                .setViewSeats(userInput)
                .build();

        // Send the message via the blocking stub and store the response
        seatResponse response = blockingStub.withDeadlineAfter(15, TimeUnit.SECONDS).seatManager(request);
        // deadline

        // Display the result
        System.out.println(response.getSeatOutput());

    }

}
