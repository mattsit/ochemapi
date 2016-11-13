import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelMain extends JPanel {

    public PanelMain() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Organic Chemistry API Demo");
        title.setFont(new Font("Verdana",1,20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59), 2));

        JButton btnEnter = new JButton("Enter");
        JButton btnExit = new JButton("Exit");

        btnEnter.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        //JFrame cards = (JFrame) SwingUtilities.getWindowAncestor(this);
        JPanel me = this;
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel cards = (JPanel) me.getParent();
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "Tools");
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()+1);
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()-1);
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
        add(btnEnter);
        add(Box.createVerticalStrut(10));
        add(btnExit);
    }

}
