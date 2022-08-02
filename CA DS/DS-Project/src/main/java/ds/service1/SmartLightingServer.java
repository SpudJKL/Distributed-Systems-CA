package ds.service1;

import ds.service1.Service1Impl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;


public class SmartLightingServer extends SmartLightingGrpc.SmartLightingImplBase {



    public static void main(String[] args) throws InterruptedException, IOException {
        SmartLightingServer service1 = new SmartLightingServer();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("SmartLightingServer started, listening on " + port);

        server.awaitTermination();
    }

    @Override
    public StreamObserver<lightRequest> smartLights(StreamObserver<lightResponse> responseObserver) {
        // somehow set user input for light on / off , brightness levels int , colour
        boolean lightstatus = lightRequest
        return super.smartLights(responseObserver);
    }

    @Override
    public void autoLights(autoLightsRequest request, StreamObserver<autoLightsResponse> responseObserver) {
        System.out.println("Auto lights on");
        boolean autoLightsStatus = request.getAutoLightsInput();
        autoLightsResponse.Builder response = autoLightsResponse.newBuilder();
        if(autoLightsStatus == true){
            // return message
            response.setAutoLightsOutput(true);
        } else {
            response.setAutoLightsOutput(false);
        }
        super.autoLights(request, responseObserver);
    }

    @Override
    public void lightMusic(lightMusicRequest request, StreamObserver<lightMusicResponse> responseObserver) {
        super.lightMusic(request, responseObserver);
    }
}
