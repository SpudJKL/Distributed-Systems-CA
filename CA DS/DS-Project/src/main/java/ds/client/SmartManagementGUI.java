package ds.client;
import ds.service2.SmartManagementGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartManagementGUI  implements ActionListener {


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

        JButton button = new JButton("Invoke smartTableBooking");
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

        JButton button = new JButton("Invoke smartQ");
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke smartView");
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

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Smart Management Controller");
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

        if (label.equals("Invoke smartTableBooking")) {
            System.out.println("smartTableBooking to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            SmartManagementGrpc.SmartManagementBlockingStub blockingStub = SmartManagementGrpc.newBlockingStub(channel);

            //preparing message to send
            ds.service2.TableRequest request = ds.service2.TableRequest.newBuilder().setTableInput(Integer.parseInt(entry1.getText())).build();

            //retreving reply from service
            ds.service2.TableResponse response = blockingStub.smartTableBooking(request);

            reply1.setText( String.valueOf( response.getTableOutput()));

        }else if (label.equals("Invoke smartQ")) {
            System.out.println("smartQ to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            SmartManagementGrpc.SmartManagementBlockingStub blockingStub = SmartManagementGrpc.newBlockingStub(channel);

            //preparing message to send
//			ds.service2.qRequest request = ds.service2.qRequest.newBuilder().setText(entry2.getText()).build();
            ds.service2.qRequest request = ds.service2.qRequest.newBuilder().setQOrder(entry2.getText()).setTime(Integer.parseInt(entry2.getText())).build();


            //retreving reply from service
//            ds.service2.qResponse response = blockingStub
//
//            reply2.setText( String.valueOf( response.getQSuccessful()) );

        }else if (label.equals("Invoke smartView")) {
            System.out.println("smartView to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            SmartManagementGrpc.SmartManagementBlockingStub blockingStub = SmartManagementGrpc.newBlockingStub(channel);

            //preparing message to send
            ds.service2.viewRequest request = ds.service2.viewRequest.newBuilder().setTotalOrders(entry3.getText()).build();

            //retreving reply from service
//            ds.service2.viewResponse response = blockingStub.smartView(request);
//
//            reply3.setText( String.valueOf( response.getOrdersTime()));

        }else{

        }

    }

}

