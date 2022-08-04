package ds.service1;

import ds.client.SmartLightingGUI;
import ds.jmDNS.Discovery;
import ds.jmDNS.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Properties;


public class SmartLightingServer extends SmartLightingGrpc.SmartLightingImplBase {


    public static void main(String[] args) throws InterruptedException, IOException {
        SmartLightingServer service1 = new SmartLightingServer();
        Registration resService = new Registration();
        Properties prop = resService.getProperties("Lighting");
        resService.registerService(prop);
        int port = 50051;
        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("SmartLightingServer started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public StreamObserver<lightRequest> smartLights(StreamObserver<lightResponse> responseObserver) {
        // somehow set user input for light on / off , brightness levels int , colour
        boolean lightstatus;
        System.out.println("pee pee poo");
        return super.smartLights(responseObserver);
    }

    @Override
    public void autoLights(autoLightsRequest request, StreamObserver<autoLightsResponse> responseObserver) {
        System.out.println("Auto lights:");
        boolean autoLightsStatus = request.getAutoLightsInput();
        System.out.println(autoLightsStatus);
        autoLightsResponse.Builder response = autoLightsResponse.newBuilder();
        if (autoLightsStatus) {
            // return message
            response.setAutoLightsOutput(true);
        } else {
            response.setAutoLightsOutput(false);
        }
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void lightMusic(lightMusicRequest request, StreamObserver<lightMusicResponse> responseObserver) {
        System.out.println("lightMusic:");
        boolean lightMusicStatus = request.getLightMusicInput();
        System.out.println(lightMusicStatus);
        lightMusicResponse.Builder response = lightMusicResponse.newBuilder();
        if (lightMusicStatus) {
            response.setLightMusicOutput(true);
        } else {
            response.setLightMusicOutput(false);
        }
        return;
    }
}
