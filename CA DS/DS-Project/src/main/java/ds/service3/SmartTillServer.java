package ds.service3;

import ds.service3.Service3Impl;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class SmartTillServer extends SmartTillGrpc.SmartTillImplBase {


    private static final Logger logger = Logger.getLogger(SmartTillServer.class.getName());


    public static void main(String[] args) throws IOException, InterruptedException {

        SmartTillServer smartTillServer = new SmartTillServer();

        int port = 50058;
        Server server = ServerBuilder.forPort(port)
                .addService((BindableService) smartTillServer)
                .build()
                .start();

        logger.info("Server started, listening on " + port);

        server.awaitTermination();
    }

    @Override
    public StreamObserver<tillRequest> smartTill(StreamObserver<tillResponse> responseObserver) {
        return super.smartTill(responseObserver);
    }

    @Override
    public void seatManager(seatRequest request, StreamObserver<seatResponse> responseObserver) {
        super.seatManager(request, responseObserver);
    }
}




