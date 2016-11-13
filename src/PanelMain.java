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

        JLabel info = new JLabel("Matthew Sit, Debbie Pao | CalHacks 2016");
        info.setFont(new Font("Verdana",1, 16).deriveFont(Font.ITALIC));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea description = new JTextArea("We created an Organic Chemistry API to represent molecules and manipulate them so that they can react and form different molecules. We have developed two examples of future inclinations of applying this to HealthCare and Medicine: showing reaction mechanisms and calculating molecular weight. This is a healthcare-focused and educational application that visually represents molecules that undergo reactions to become new molecules that are used in drugs or medicine in the health field currently. In order to provide a demo of what we have implemented, we have created this simple GUI to show the flexibility and extensibility of our implementation.",
                10,100);
        description.setFont(new Font("Verdana",1,16));
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        description.setEditable(false);
        description.setBackground(null);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        add(info);
        add(Box.createVerticalStrut(20));
        add(btnEnter);
        add(Box.createVerticalStrut(10));
        add(btnExit);
        add(Box.createVerticalStrut(10));
        add(description);
    }

}
