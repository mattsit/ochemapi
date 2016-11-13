import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/12/2016.
 */
public class Main {
    public static void main(String args[]) {
        JFrame f = new JFrame("Organic Chemistry");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(700, 700);

        Molecule alcohol = new Molecule();
        Atom c = new Atom(6);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom o = new Atom(8);
        alcohol.addAtom(c);
        alcohol.addAtom(o);
        alcohol.addAtom(h);
        alcohol.addAtom(h2);
        alcohol.addAtom(h3);
        alcohol.addAtom(h4);
        alcohol.addBond(c, h);
        alcohol.addBond(c, h2);
        alcohol.addBond(c, h3);
        alcohol.addBond(c, o);
        alcohol.addBond(h4, o);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel p = new MoleculePanel(alcohol);
        new PCC().action(alcohol);
        JPanel p2 = new MoleculePanel(alcohol);

        //p.setBackground(Color.blue);
        //JPanel mainMolecule = new JPanel();
        //mainMolecule.setBackground(Color.black);
        //JPanel choose = new JPanel();
        //choose.setBackground(Color.green);
        //p.add(mainMolecule);
        //p.add(choose);
        //p.add(new JButton("Button1"));
       // p.add(new JButton("Button2"));
       // p.add(new JButton("Button3"));
        container.add(p);
        container.add(p2);
        //f.getContentPane().add(p);
        //f.getContentPane().add(p2);
        f.getContentPane().add(container);
        f.setBackground(Color.RED);
        f.setVisible(true);


    }
}
