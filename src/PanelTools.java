import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelTools extends JPanel {

    public PanelTools() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Organic Chemistry API Demo");
        title.setFont(new Font("Verdana",1,20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59), 2));

        JButton btnMW = new JButton("Molecular Weight");
        JButton btnMech = new JButton("Mechanisms");
        JButton btnExit = new JButton("Exit");

        btnMW.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMech.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel me = this;
        btnMW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrameMW();
            }
        });

        btnMech.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrameMech();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(Box.createVerticalStrut(200));
        add(title);
        add(Box.createVerticalStrut(70));
        add(btnMW);
        add(Box.createVerticalStrut(10));
        add(btnMech);
        add(Box.createVerticalStrut(10));
        add(btnExit);
    }
}
