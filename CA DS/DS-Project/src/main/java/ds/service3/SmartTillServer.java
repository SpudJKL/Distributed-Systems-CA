package ds.service3;

import ds.jmDNS.Registration;
import ds.service3.Service3Impl;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class SmartTillServer extends SmartTillGrpc.SmartTillImplBase {


    private static final Logger logger = Logger.getLogger(SmartTillServer.class.getName());


    public static void main(String[] args) throws IOException, InterruptedException {

        SmartTillServer smartTillServer = new SmartTillServer();
        Registration resService = new Registration();
        Properties prop = resService.getProperties("");
        resService.registerService(prop);
        int port = 50053;
        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(smartTillServer)
                    .build()
                    .start();

            System.out.println("SmartTillServer started, listening on " + port);

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
    public StreamObserver<tillRequest> smartTill(StreamObserver<tillResponse> responseObserver) {
        return super.smartTill(responseObserver);
    }

    @Override
    public void seatManager(seatRequest request, StreamObserver<seatResponse> responseObserver) {
        super.seatManager(request, responseObserver);
    }
}




