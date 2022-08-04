package ds.service2;

import ds.jmDNS.Registration;
import ds.service1.SmartLightingServer;
import ds.service2.Service2Impl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
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


    @Override
    public void smartTableBooking(TableRequest request, StreamObserver<TableResponse> responseObserver) {
        System.out.println("yo yo yo");
    }

    @Override
    public StreamObserver<qRequest> smartQ(StreamObserver<qResponse> responseObserver) {
        return super.smartQ(responseObserver);
    }

    @Override
    public void smartView(viewRequest request, StreamObserver<viewResponse> responseObserver) {
        super.smartView(request, responseObserver);
    }
}
