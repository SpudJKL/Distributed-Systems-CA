package ds.client;

import ds.service1.*;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ds.jmDNS.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class SmartLightingClient {
    private static SmartLightingGrpc.SmartLightingBlockingStub blockingStub;
    private static SmartLightingGrpc.SmartLightingStub asyncStub;


    public static void main(String[] args) throws InterruptedException {

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
        // Sleep for 1 sec for flow of output
        TimeUnit.SECONDS.sleep(1);
        // Taking userInput
        System.out.println();
        System.out.println("SmartLighting");
        int choice;
        do {
            System.out.println();
            System.out.println("SmartLighting");
            System.out.println("Please make your choice");
            System.out.println("1: smartLights()");
            System.out.println("2: autoLights()");
            System.out.println("3: lightMusic()");
            System.out.println("4: Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    smartLights();
                    break;
                case 2:
                    autoLights();
                    break;
                case 3:
                    lightMusic();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 4);
        channel.shutdown().awaitTermination(5000, TimeUnit.MILLISECONDS);
    }

    // RPC Methods

    // Bi-Directional
    public static void smartLights() {
        StreamObserver<lightResponse> responseObserver = new StreamObserver<lightResponse>() {
            @Override
            public void onNext(lightResponse value) {
                onCompleted();
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
        StreamObserver<lightRequest> requestObserver = asyncStub.withDeadlineAfter(15, TimeUnit.SECONDS).smartLights(responseObserver);
        // deadline

        try {
            // Prompting user
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("--smartLights--");
            System.out.println("Please enter your choices");
            System.out.println("Light on / off");
            System.out.println("True = on");
            System.out.println("False = off ");
            boolean lightStatus = sc.nextBoolean();

            System.out.println();

            System.out.println("Brightness");
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

            // Build the request message
            lightRequest request = lightRequest.newBuilder()
                    .setLightOn(lightStatus)
                    .setBrightnessInput(brightness)
                    .setColour(colour)
                    .build();

            requestObserver.onNext(request);


            // End the requests
            requestObserver.onCompleted();

            // Sleep for a bit before sending the next one.
            Thread.sleep(500);

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
        // Prompting user
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("--autoLights--");
        System.out.println("Please enter your choices");
        System.out.println("autoLights on / off");
        System.out.println("True = on");
        System.out.println("False = off ");
        boolean lightStatus = sc.nextBoolean();


        // Build the request message
        autoLightsRequest request = autoLightsRequest.newBuilder()
                .setAutoLightsInput(lightStatus)
                .build();

        // Send the message via the blocking stub and store the response
        autoLightsResponse response = blockingStub.withDeadlineAfter(15, TimeUnit.SECONDS).autoLights(request);
        // deadline

        // Display the result
        System.out.println("autoLights status: " + response.getAutoLightsOutput() + ". " + response.getDimLevels());
        return;
    }

    // Server-streaming

    public static void lightMusic() {
        // Prompting user
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("--lightMusic--");
        System.out.println("Please enter your choices");
        System.out.println("lightMusic on / off");
        System.out.println("True = on");
        System.out.println("False = off ");
        boolean lightStatus = sc.nextBoolean();

        // Build the request message
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
        asyncStub.withDeadlineAfter(15, TimeUnit.SECONDS).lightMusic(request, responseObserver);

        // deadline

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}






