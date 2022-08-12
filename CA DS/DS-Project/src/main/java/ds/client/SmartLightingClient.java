package ds.client;

import java.util.Random;
import java.util.Scanner;
import ds.jmDNS.Discovery;
import ds.service1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;

public class SmartLightingClient {
    private static SmartLightingGrpc.SmartLightingBlockingStub blockingStub;
    private static SmartLightingGrpc.SmartLightingStub asyncStub;


    public static void main(String[] args) {

        // Discover the jmDNS service
        Discovery discovery = new Discovery();
        String service_type = "_smartlighting_http._tcp.local.";
        discovery.discoverService(service_type);
        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        // Create stubs
        blockingStub = SmartLightingGrpc.newBlockingStub(channel);
        asyncStub = SmartLightingGrpc.newStub(channel);
        // taking userInput
        System.out.println("SmartLighting");
        System.out.println();
        System.out.println("Please make your choice");
        System.out.println("1: smartLights()");
        System.out.println("2: autoLights()");
        System.out.println("3: lightMusic()");
        System.out.println("4: Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        do {

            switch (choice) {
                case 1: smartLights();
                        break;
                case 2: autoLights();
                        break;
                case 3: lightMusic();
                        break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 4);
    }

    // RPC Methods

    // Bi-Directional
    public static void smartLights() {
        StreamObserver<lightResponse> responseObserver = new StreamObserver<lightResponse>() {
            @Override
            public void onNext(lightResponse value) {
                System.out.println("Light: " + value.getLightOff());
                System.out.println("Brightness" +value.getBrightnessOutput());
                System.out.println("Colour" + value.getColour());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("smartLights() bidirectional-streaming has failed!");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("smartLights() bidirectional-streaming has finished");
            }

        };

        // Client sends the requests here via the asynchronous stub
        StreamObserver<lightRequest> requestObserver = asyncStub.smartLights(responseObserver);

        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("smartLights");
            System.out.println();
            System.out.println("Please enter your choices");
            System.out.println();
            System.out.println("Light on / off");
            System.out.println("Provide true or false");
            boolean lightStatus = sc.nextBoolean();

            System.out.println();

            System.out.println("Brightness");
            System.out.println();

            int brightness = 0;

            do {
                System.out.println("Please enter a valid input: Between 1 to 100 ");
                if (sc.hasNext()) {
                    brightness = sc.nextInt();
                } else {
                    sc.next();
                    System.out.print("Incorrect input provided! ");
                }
            } while (!(brightness >= 1 & brightness <= 100));

            System.out.println();

            System.out.println("Colour");
            int colour = 0;
            do {
                System.out.println("Please enter a valid input: Between 0 to 255");
                if (sc.hasNext()) {
                    colour = sc.nextInt();
                } else {
                    sc.next();
                    System.out.print("Incorrect input provided! ");
                }
            } while (!(colour >= 0 & colour <= 255));


            lightRequest request = lightRequest.newBuilder()
                    .setLightOn(lightStatus)
                    .setBrightnessInput(brightness)
                    .setColour(colour)
                    .build();

            requestObserver.onNext(request);


            // End the requests
            requestObserver.onCompleted();

            // Sleep for a bit before sending the next one.
            Thread.sleep(new Random().nextInt(1000) + 500);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Unary

    public static void autoLights() {

        Scanner sc = new Scanner(System.in);
        System.out.println("autoLights");
        System.out.println();
        System.out.println("Please enter your choices");
        System.out.println();
        System.out.println("autoLights on / off");
        System.out.println("Provide 1 or 0");
        boolean lightStatus = sc.nextBoolean();


        // Build the request message
        autoLightsRequest request = autoLightsRequest.newBuilder()
                .setAutoLightsInput(lightStatus)
                .build();

        // Send the message via the blocking stub and store the response
        autoLightsResponse response = blockingStub.autoLights(request);

        // Display the result
        System.out.println("autoLights status: " + response.getAutoLightsOutput()+ " Dim levels: " +response.getDimLevels());

    }

    // Server-streaming

    public static void lightMusic() {

        // Display a message to show what method has been called
        Scanner sc = new Scanner(System.in);
        System.out.println("lightMusic");
        System.out.println();
        System.out.println("Please enter your choices");
        System.out.println();
        System.out.println("lightMusic on / off");
        System.out.println("Provide 1 or 0");
        boolean lightStatus = sc.nextBoolean();

        lightMusicRequest request = lightMusicRequest.newBuilder()
                .setLightMusicInput(lightStatus)
                .build();

        StreamObserver<lightMusicResponse> responseObserver = new StreamObserver<lightMusicResponse>() {


            @Override
            public void onNext(lightMusicResponse value) {
                System.out.println(value.getLightMusicOutput());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("lightMusic() Server-streaming has failed!");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

                // Server-streaming is completed
                System.out.println("lightMusic() Server-streaming has completed!");
            }

        };

        // Client sends the request here via the asynchronous stub
        asyncStub.lightMusic(request, responseObserver);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}






