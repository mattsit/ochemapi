import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/12/2016.
 */
public class Main {
    public static void main(String args[]) {
//        JFrame f = new JFrame("Organic Chemistry");
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setSize(400, 300);
//        JPanel p = new JPanel();
//        p.setBackground(Color.blue);
//        JPanel mainMolecule = new JPanel();
//        mainMolecule.setBackground(Color.black);
//        JPanel choose = new JPanel();
//        choose.setBackground(Color.green);
//        p.add(mainMolecule);
//        p.add(choose);
//        //p.add(new JButton("Button1"));
//       // p.add(new JButton("Button2"));
//       // p.add(new JButton("Button3"));
//        f.getContentPane().add(p, BorderLayout.CENTER);
//        f.setVisible(true);

        Atom a =  new Atom(20);
        System.out.println(a.toString());
    }
}
