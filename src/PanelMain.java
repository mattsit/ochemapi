import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelMain extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Main", 20, 20);
        g.fill3DRect(0, 0, 20, 20, false);
        JButton entr = new JButton("Enter");
        JButton ext = new JButton("Exit");

        ext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("exiting");

            }
        });
        this.add(ext);
    }

}
