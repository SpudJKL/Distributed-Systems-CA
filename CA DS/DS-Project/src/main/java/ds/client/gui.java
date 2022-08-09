package ds.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
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

    public gui() {
        smartLightsOnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui");
        frame.setContentPane(new gui().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
