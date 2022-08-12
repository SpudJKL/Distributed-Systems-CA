package ds.client;

import ds.jmDNS.Discovery;
import ds.jmDNS.Registration;
import ds.service1.SmartLightingGrpc;
import ds.service1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;



public class SmartLightingGUI  implements ActionListener {


    private JTextField entry1, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;



    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke smartLights");
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

        JLabel label = new JLabel("Enter true or false")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke autoLights");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2 .setEditable(false);
        panel.add(reply2 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter true or false")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke lightMusic");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3 .setEditable(false);
        panel.add(reply3 );

        panel.setLayout(boxlayout);

        return panel;

    }


    public static void main(String[] args) {

        SmartLightingGUI gui = new SmartLightingGUI();
        Discovery dsService = new Discovery();

        String service_type = "_SmartLighting._tcp.local.";
        dsService.discoverService(service_type);

        String host = "localhost";
        int port = 50051;
        gui.build();
    }

    void build() {

        JFrame frame = new JFrame("Smart Lighting Controller");
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
        panel.add( getService3JPanel() );


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

        if (label.equals("Invoke smartLights")) {
            System.out.println("smartLights to be invoked ...");
            // creating a channel for SmartLightingGrpc
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            SmartLightingGrpc.SmartLightingStub asyncStub = SmartLightingGrpc.newStub(channel);


            //preparing message to send
            lightRequest request = ds.service1.lightRequest.newBuilder().setLightOn(Boolean.parseBoolean(entry1.getText())).setBrightnessInput(Integer.parseInt(entry1.getText())).setColour(Integer.parseInt(entry1.getText())).build();

//            lightResponse responseObserver = asyncStub.smartLights(request, responseObserver);
////
//            reply1.setText(responseObserver.(Integer.parseInt(getBrightnessOutput()));

        }else if (label.equals("Invoke autoLights")) {
            System.out.println("autoLights to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            SmartLightingGrpc.SmartLightingBlockingStub blockingStub = SmartLightingGrpc.newBlockingStub(channel);

            //preparing message to send
            autoLightsRequest request = ds.service1.autoLightsRequest.newBuilder().setAutoLightsInput(Boolean.parseBoolean(entry2.getText())).build();


            //retreving reply from service
            autoLightsResponse response = blockingStub.autoLights(request);

            reply2.setText( String.valueOf(response.getAutoLightsOutput()) );
            channel.shutdown();

        }else if (label.equals("Invoke lightMusic")) {
            System.out.println("lightMusic to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            SmartLightingGrpc.SmartLightingBlockingStub blockingStub = SmartLightingGrpc.newBlockingStub(channel);

            //preparing message to send
            lightMusicRequest request = ds.service1.lightMusicRequest.newBuilder().setLightMusicInput(Boolean.parseBoolean(entry3.getText())).build();

            //retreving reply from service
//            lightMusicResponse response = blockingStub.
//
//
//            reply3.setText( String.valueOf( response.getLightMusicOutput()) );



        }

    }

}

