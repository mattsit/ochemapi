import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelMech extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Mech", 20, 20);

        JLabel title = new JLabel("Mechanisms");
        title.setFont(new Font("Verdana",1,14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59), 2));

        JButton btnGenerate = new JButton("React!");
        btnGenerate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton lif = new JButton("LiF");
        JButton ch3oh = new JButton("CH3OH");
        JButton nai = new JButton("NaI");
        JButton och3 = new JButton("OCH3");
        JButton h2O = new JButton("H2O");

        JPanel me = this;
        






    }
}
