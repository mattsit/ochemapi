import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelTools extends JPanel {
    JFrame jf = new JFrame();

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Tools", 20, 20);
        JButton mw = new JButton("Molecular Weight") {
            {
                setSize(150, 30);
                setMaximumSize(getSize());
            }
        };
        JButton mech = new JButton("Mechanism") {
            {
                setSize(150, 30);
                setMaximumSize(getSize());
            }
        };
        JButton ext = new JButton("Exit") {
            {
                setSize(150, 30);
                setMaximumSize(getSize());
            }
        };


        ext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("exiting");
                //this.dispose();  //Remove JFrame 1
                jf.setVisible(true); //Show other frame
            }
        });
        this.add(mw);
        this.add(mech);
        this.add(ext);


    }
}
