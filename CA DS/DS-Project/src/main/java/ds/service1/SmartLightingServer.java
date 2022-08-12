package ds.service1;

import ds.jmDNS.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SmartLightingServer extends SmartLightingGrpc.SmartLightingImplBase {


    public static void main(String[] args) throws InterruptedException, IOException {
        SmartLightingServer service1 = new SmartLightingServer();
        Registration reg = new Registration();
        reg.registerService("_smartlighting_http._tcp.local.","SmartLighting", 50051, "service for Smart Lighting operations");
        int port = 50051;
        try {

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

    // bi-directional streaming
    @Override
    public StreamObserver<lightRequest> smartLights(StreamObserver<lightResponse> responseObserver) {
        return new StreamObserver<lightRequest>() {
            @Override
            public void onNext(lightRequest value) {
                // parse data from info
                boolean light = value.getLightOn();
                int brightness = value.getBrightnessInput();
                int colour = value.getColour();

                lightResponse response = lightResponse.newBuilder().setLightOff(light).setColour(colour).setBrightnessOutput(brightness).build();

                responseObserver.onNext(response);
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
        boolean autoLightsStatus = request.getAutoLightsInput();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        int Random = (int)(Math.random()*100);
        LocalDateTime now = LocalDateTime.now();
        autoLightsResponse.Builder response = autoLightsResponse.newBuilder();
        if (autoLightsStatus) {
            response.setAutoLightsOutput(true);
            System.out.println("autoLights on");
            response.setDimLevels("The time is: " + dtf.format(now) + "." + " The lights has been automatically-dim'd to "+ Random +"% brightness");

        } else {
            response.setAutoLightsOutput(false);
            System.out.println("autoLights off");
        }
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Server Streaming
    @Override
    public void lightMusic(lightMusicRequest request, StreamObserver<lightMusicResponse> responseObserver) {
        System.out.println("-lightMusic-");
        boolean lightMusicStatus = request.getLightMusicInput();
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

