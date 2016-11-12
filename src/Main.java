import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/12/2016.
 */
public class Main {
    public static void main(String args[]) {
        JFrame f = new JFrame("Organic Chemistry");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        JPanel p = new JPanel();
        p.add(new JButton("test"));
        f.getContentPane().add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
