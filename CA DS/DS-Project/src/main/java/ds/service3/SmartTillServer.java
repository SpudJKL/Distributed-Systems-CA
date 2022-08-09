package ds.service3;


import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import ds.jmDNS.Registration;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class SmartTillServer extends SmartTillGrpc.SmartTillImplBase {


    private static final Logger logger = Logger.getLogger(SmartTillServer.class.getName());
    char[][] seats = Seats.fill();


    public static void main(String[] args) throws IOException, InterruptedException {
        SmartTillServer smartTillServer = new SmartTillServer();
        Registration reg = new Registration();
        reg.registerService("_SmartTill._tcp.local.","SmartTill", 50053, "service for Smart Till operations");
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

    // bi-directional streaming
    @Override
    public StreamObserver<tillRequest> smartTill(StreamObserver<tillResponse> responseObserver) {
        ArrayList<String> orders = new ArrayList<>();
        return new StreamObserver<tillRequest>() {
            @Override
            public void onNext(tillRequest value) {
                // store information from client

                String orderInfo = value.getOrderInput();
                orders.add(orderInfo);
                int col = value.getSeatCol();
                int row = value.getSeatRow();

                // pass these variables to the method to set the table as taken
                Seats.addseat(row, col, seats);
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {

                tillResponse response = tillResponse.newBuilder()
                        .setTotalOrdersOutput(String.valueOf(orders.toString()))
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    // Unary
    @Override
    public void seatManager(seatRequest request, StreamObserver<seatResponse> responseObserver) {
        System.out.println("-seatManager-");
        String seatStatus = request.getViewSeats();
        seatResponse.Builder response = seatResponse.newBuilder();
        response.setTotalSeats("See console for output");

        Seats.showSeats(seats);
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}








