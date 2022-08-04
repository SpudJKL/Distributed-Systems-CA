package ds.client;

import ds.jmDNS.Discovery;
import ds.service3.SmartTillGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartTillGUI  implements ActionListener {


    private JTextField entry1, reply1;
    private JTextField entry2, reply2;




    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke smartTill");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 10);
        reply1 .setEditable(false);
        panel.add(reply1 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke seatManager");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2 .setEditable(false);
        panel.add(reply2 );

        panel.setLayout(boxlayout);

        return panel;

    }




    public static void main(String[] args) {

        SmartTillGUI smart = new SmartTillGUI();
        Discovery dsService = new Discovery();

        String service_type = "_SmartTill._tcp.local.";
        dsService.discoverService(service_type);

//        String host = dsService.serviceInfo.getHostAddresses()[1];
//        int port = dsService.serviceInfo.getPort();
        String host = "localhost";
        int port = 50053;
        smart.build();
    }

    private void build() {

        JFrame frame = new JFrame("Smart Till Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getService1JPanel() );
        panel.add( getService2JPanel() );



        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Invoke smartTill")) {
            System.out.println("smartTill to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            SmartTillGrpc.SmartTillBlockingStub blockingStub = SmartTillGrpc.newBlockingStub(channel);

            //preparing message to send
            ds.service3.tillRequest request = ds.service3.tillRequest.newBuilder().setOrderInput(entry1.getText()).build();

            //retreving reply from service
//            ds.service3.tillResponse response = blockingStub.
//
//            reply1.setText( String.valueOf( response.getTotalOrdersOutput()));

        }else if (label.equals("Invoke seatManager")) {
            System.out.println("seatManager to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            SmartTillGrpc.SmartTillBlockingStub blockingStub = SmartTillGrpc.newBlockingStub(channel);

            //preparing message to send
//			ds.service2.qRequest request = ds.service2.qRequest.newBuilder().setText(entry2.getText()).build();
            ds.service3.seatRequest request = ds.service3.seatRequest.newBuilder().setSeats(entry2.getText()).build();


            //retreving reply from service
            ds.service3.seatResponse response = blockingStub.seatManager(request);

            reply2.setText( String.valueOf( response.getTotalSeats()) );


        }

    }

}

