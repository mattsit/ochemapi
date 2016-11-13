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

        Molecule water = new Molecule();
        Atom o = new Atom(8);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        water.addAtom(o);
        water.addAtom(h);
        water.addAtom(h2);
        water.addBond(o, h);
        water.addBond(o, h2);

        Molecule alkene = new Molecule();
        Atom c = new Atom(6);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom o2 = new Atom(8);
        alkene.addAtom(c);
        alkene.addAtom(o2);
        alkene.addAtom(h3);
        alkene.addAtom(h4);
        alkene.addBond(c, h3);
        alkene.addBond(c, h4);
        alkene.addBond(c, o, 2);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel p = new MoleculePanel(water);
        JPanel p2 = new MoleculePanel(alkene);

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
