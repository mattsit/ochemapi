import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/12/2016.
 */
public class Main {
    public static void main(String args[]) {
        JFrame f = new JFrame("Organic Chemistry API Demo");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(700, 700);

        Molecule alcohol = sample2();

        /*
        JPanel p = new MoleculePanel(alcohol);
        Molecule alcohol2 = new PCC().action(alcohol);
        JPanel p2 = new MoleculePanel(alcohol2);*/


        JPanel main = new PanelMain();
        JPanel tools = new PanelTools();
        JPanel mech = new PanelMech();

        JPanel cards = new JPanel(new CardLayout());
        cards.add(main, "Main");
        cards.add(tools, "Tools");
        cards.add(mech, "Mech");

        CardLayout cl = (CardLayout) cards.getLayout();

        cl.show(cards, "Main");
        f.getContentPane().add(cards);
        f.setVisible(true);
    }

    private static Molecule sample1() {
        Molecule m = new Molecule();
        Atom si = new Atom(14);
        Atom si2 = new Atom(14);
        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom o = new Atom(8);
        Atom h1 = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom h5 = new Atom(1);
        Atom h6 = new Atom(1);
        Atom h7 = new Atom(1);
        Atom h8 = new Atom(1);

        m.addAtom(c1);
        m.addAtom(si);
        m.addBond(c1, si);
        m.addAtom(h1);
        m.addBond(c1, h1);
        m.addAtom(c2);
        m.addBond(c1, c2);
        m.addAtom(si2);
        m.addAtom(h2);
        m.addAtom(h3);
        m.addAtom(h4);
        m.addBond(si, h2);
        m.addBond(si, h3);
        m.addBond(si, h4);
        m.addAtom(h5);
        m.addAtom(o);
        m.addBond(si2, h5);
        m.addBond(si2, o, 2);
        m.addAtom(h6);
        m.addAtom(h7);
        m.addAtom(h8);
        m.addBond(c2, h6);
        m.addBond(c2, h7);
        m.addBond(c2, h8);
        m.addBond(c1,si2);

        return m;
    }

    private static Molecule sample2() {
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

        return alcohol;
    }
}
