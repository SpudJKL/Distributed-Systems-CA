package ds.client;

import ds.jmDNS.Discovery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartLightGui {
    private JPanel MainPanel;
    private JComboBox labelComboBox;
    private JLabel smartLightsLabel;
    private JLabel autoLightsLabel;
    private JLabel lightMusic;
    private JTextField brightnessField;
    private JButton smartLightsOnOffButton;
    private JTextField colourField;
    private JButton autoLightsButton;
    private JButton lightMusicButton;


//    public SmartLightGui() {
//        SmartLightingGUI gui = new SmartLightingGUI();
//        Discovery dsService = new Discovery();
//
//        String service_type = "_SmartLighting._tcp.local.";
//        dsService.discoverService(service_type);
//
//        String host = "localhost";
//        int port = 50051;
//        gui.build();
//        smartLightsOnOffButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                smartLightsOnOffButton.addActionListener(this);
//                smartLightsOnOffButton.getActionCommand();
//
//        });
//    }
//
//    void build() {
//        JFrame frame = new JFrame("Project GUI - SmartLighting");
//        frame.setContentPane(new SmartLightGui().MainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setSize(800, 300);
//        frame.setVisible(true);
//    }
//
//
//    public static void main(String[] args) {
//        SmartLightGui gui = new SmartLightGui();
//        Discovery dsService = new Discovery();
//
//        String service_type = "_SmartLighting._tcp.local.";
//        dsService.discoverService(service_type);
//
//        String host = "localhost";
//        int port = 50051;
//        gui.build();
//    }
//}
}