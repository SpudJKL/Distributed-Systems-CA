package ds.service1;

import ds.jmDNS.*;
import io.grpc.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SmartLightingServer extends SmartLightingGrpc.SmartLightingImplBase {


    public static void main(String[] args) throws InterruptedException, IOException {
        SmartLightingServer service1 = new SmartLightingServer();
        Registration reg = new Registration();
        reg.registerService("_smartlighting_http._tcp.local.","SmartLighting", 50051, "service for Smart Lighting operations");
        int port = 50051;
        try {
            // Create new Server
            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("SmartLightingServer started, listening on " + port);

            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    // RPC methods

    // Bi-Directional streaming
    @Override
    public StreamObserver<lightRequest> smartLights(StreamObserver<lightResponse> responseObserver) {
        return new StreamObserver<lightRequest>() {
            @Override
            public void onNext(lightRequest value) {
                // parse data from info
                boolean light = value.getLightOn();
                int brightness = value.getBrightnessInput();
                int colour = value.getColour();

                // Build the response
                lightResponse response = lightResponse.newBuilder().setLightOff(light).setColour(colour).setBrightnessOutput(brightness).build();

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    // Unary
    @Override
    public void autoLights(autoLightsRequest request, StreamObserver<autoLightsResponse> responseObserver) {
        System.out.println("-Auto lights-");
        // Get input
        boolean autoLightsStatus = request.getAutoLightsInput();
        boolean tempLight = false;
        String tempDim ="";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        int Random = (int)(Math.random()*100);
        LocalDateTime now = LocalDateTime.now();
        if (autoLightsStatus) {
            tempLight = true;
            System.out.println("autoLights on");
            tempDim = ("The time is: " + dtf.format(now) + "." + " The lights has been automatically-dim'd to " + Random + "% brightness");
        }
        else {
            tempLight = false;
            System.out.println("autoLights off");
        }
        // Build the response
        autoLightsResponse response = autoLightsResponse.newBuilder()
                .setAutoLightsOutput(tempLight)
                .setDimLevels(tempDim)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Unary
//    @Override
//    public void autoLights(autoLightsRequest request, StreamObserver<autoLightsResponse> responseObserver) {
//        System.out.println("-Auto lights-");
//        boolean autoLightsStatus = request.getAutoLightsInput();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//        int Random = (int)(Math.random()*100);
//        LocalDateTime now = LocalDateTime.now();
//        autoLightsResponse.Builder response = autoLightsResponse.newBuilder();
//        if (autoLightsStatus) {
//            response.setAutoLightsOutput(true);
//            System.out.println("autoLights on");
//            response.setDimLevels("The time is: " + dtf.format(now) + "." + " The lights has been automatically-dim'd to "+ Random +"% brightness");
//
//        } else {
//            response.setAutoLightsOutput(false);
//            System.out.println("autoLights off");
//        }
//
//        response.build();
//        responseObserver.onNext(response.build());
//        responseObserver.onCompleted();
//    }

    // Server Streaming
    @Override
    public void lightMusic(lightMusicRequest request, StreamObserver<lightMusicResponse> responseObserver) {
        System.out.println("-lightMusic-");
        // Get input
        boolean lightMusicStatus = request.getLightMusicInput();
        // Build the response
        lightMusicResponse.Builder response = lightMusicResponse.newBuilder();
        if (lightMusicStatus) {
            response.setLightMusicOutput(true);
            System.out.println("lightMusic on");
        } else {
            response.setLightMusicOutput(false);
            System.out.println("lightMusic off");
        }
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

}

