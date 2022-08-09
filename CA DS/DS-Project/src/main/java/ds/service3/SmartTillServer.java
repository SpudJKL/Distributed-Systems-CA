package ds.service3;

import ds.jmDNS.Registration;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import ds.service1.lightRequest;
import ds.service1.lightResponse;
import ds.service2.Order;
import ds.service2.qResponse;
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
        return new StreamObserver<tillRequest>() {
            @Override
            public void onNext(tillRequest value) {
                // store information from client
                ArrayList<String> orders = new ArrayList<>();
                String orderInfo = value.getOrderInput();
                orders.add(orderInfo);
                int col = value.getSeatCol();
                int row = value.getSeatRow();
                char[][] seats = {};
                // pass these variables to the method to set the table as taken
                Seats.addseat(row, col);
                tillResponse.Builder response = tillResponse.newBuilder().setTotalOrdersOutput(orderInfo);
                response.setTotalOrdersOutput(orders.toString());
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

    @Override
    public void seatManager(seatRequest request, StreamObserver<seatResponse> responseObserver) {
        System.out.println("-seatManager-");
        String seatStatus = request.getViewSeats();
        seatResponse.Builder response = seatResponse.newBuilder();
        response.setTotalSeats("For output look at the console");
        Seats.showSeats();
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}








