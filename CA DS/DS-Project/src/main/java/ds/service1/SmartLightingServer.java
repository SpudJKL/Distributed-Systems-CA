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
        Properties prop = resService.getProperties("SmartLighting");
        resService.registerService(prop);
        int port = Integer.parseInt(prop.getProperty("service_port"));
        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("SmartLightingServer started, listening on " + port);

            server.awaitTermination();

        } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }  catch(InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

    @Override
    public StreamObserver<lightRequest> smartLights(StreamObserver<lightResponse> responseObserver) {
        // somehow set user input for light on / off , brightness levels int , colour
        boolean lightstatus;
        return super.smartLights(responseObserver);
    }

    @Override
    public void autoLights(autoLightsRequest request, StreamObserver<autoLightsResponse> responseObserver) {
        System.out.println("Auto lights on");
        boolean autoLightsStatus = request.getAutoLightsInput();
        autoLightsResponse.Builder response = autoLightsResponse.newBuilder();
        if(autoLightsStatus != false){
            // return message
            response.setAutoLightsOutput(true);
        } else {
            response.setAutoLightsOutput(false);
        }
        super.autoLights(request, responseObserver);
    }

    @Override
    public void lightMusic(lightMusicRequest request, StreamObserver<lightMusicResponse> responseObserver) {
        boolean lightMusicStatus = request.getLightMusicInput();
        lightMusicResponse.Builder response = lightMusicResponse.newBuilder();
        if (lightMusicStatus != false){
            response.setLightMusicOutput(true);
        } else {
            response.setLightMusicOutput(false);
        }
        super.lightMusic(request, responseObserver);
    }
}
