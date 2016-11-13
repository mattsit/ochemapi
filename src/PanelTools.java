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

        btnMW.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMech.setAlignmentX(Component.CENTER_ALIGNMENT);

        //JFrame cards = (JFrame) SwingUtilities.getWindowAncestor(this);
        JPanel me = this;
        btnMW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel cards = (JPanel) me.getParent();
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "MW");
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()+1);
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()-1);
            }
        });

        btnMech.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel cards = (JPanel) me.getParent();
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "Mech");
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()+1);
                cards.getParent().setSize(cards.getParent().getWidth(), cards.getParent().getHeight()-1);
            }
        });

        add(Box.createVerticalStrut(200));
        add(title);
        add(Box.createVerticalStrut(70));
        add(btnMW);
        add(Box.createVerticalStrut(10));
        add(btnMech);
    }
}
