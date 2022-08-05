package ds.service3;

import ds.jmDNS.Registration;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import ds.service1.lightRequest;
import ds.service1.lightResponse;
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
                // parse data from info
                String orderInfo = value.getOrderInput();
                int col = value.getSeatCol();
                int row = value.getSeatRow();
                char[][] seats = Seats();
                // pass these variables to the method to set the table as taken
                addseat(row, col, seats);

                tillResponse.Builder response = tillResponse.newBuilder().setTotalOrdersOutput(orderInfo);
                response.setTotalOrdersOutput(orderInfo + orderInfo);

//                responseObserver.onNext(response);
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
        char[][] seats = Seats();
        seatResponse.Builder response = seatResponse.newBuilder();
        response.setTotalSeats(printSeats(seats));
        response.build();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public static char[][] Seats() {
        // create seats
        int rows = 7;
        int cols = 7;
        int totalSeats = cols * rows;
        char[][] seats = new char[cols][rows];
        for (char[] row : seats) {
            Arrays.fill(row, 'S');
        }
        return seats;
    }

    public static String printSeats(char[][] seats) {
        System.out.println("Seats View");
        for (int i = 0; i <= seats[0].length; i++) {
            for (int j = 0; j <= seats.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + j);
                    }
                } else {
                    if (j == 0) {
                        System.out.print(i);
                    } else {
                        System.out.print(" " + seats[j - 1][i - 1]);
                    }
                }
            }
            System.out.print("\n");
        }
        return null;
    }

    public void addseat(int row,int col, char[][] seat){
        System.out.println("Enter a row number:");
        int Row=row;
        System.out.println("Enter a seat number in that row:");
        int Col=col;
        seat[Col - 1][Row - 1] = 'X';

    }
}








