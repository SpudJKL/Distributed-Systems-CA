package ds.service2;
import ds.service1.SmartLightingServer;
import ds.service2.Service2Impl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class SmartManagementServer extends SmartManagementGrpc.SmartManagementImplBase {

    public static void main(String[] args) throws InterruptedException, IOException {
        SmartManagementServer service1 = new SmartManagementServer();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("SmartManagementServer started, listening on " + port);

        server.awaitTermination();
    }

    @Override
    public void smartTableBooking(TableRequest request, StreamObserver<TableResponse> responseObserver) {
        super.smartTableBooking(request, responseObserver);
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
