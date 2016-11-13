import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelMW extends JFrame {

    public PanelMW() {
        super("Molecular Weight Calculator");

        JTextField t = new JTextField();
        JButton calculate = new JButton("Calculate!");
        JButton h = new JButton("H");
        JButton he = new JButton("He");
        JButton li = new JButton("Li");
        JButton be = new JButton ("Be");
        JButton b = new JButton("B");
        JButton c = new JButton("C");
        JButton n = new JButton("N");
        JButton o = new JButton("O");
        JButton fluorine = new JButton("F");
        JButton ne = new JButton("Ne");
        JButton na = new JButton("Na");
        JButton mg = new JButton("Mg");
        JButton al = new JButton("Al");
        JButton si = new JButton("Si");
        JButton p = new JButton("P");
        JButton s = new JButton("S");
        JButton cl = new JButton("Cl");

        t.setBounds(30,40,280,30);
        h.setBounds(40,100,50,40);
        he.setBounds(110,100,50,40);
        li.setBounds(180,100,50,40);

        be.setBounds(40,170,50,40);
        b.setBounds(110,170,50,40);
        c.setBounds(180,170,50,40);
        n.setBounds(250,170,50,40);

        o.setBounds(40,240,50,40);
        fluorine.setBounds(110,240,50,40);
        ne.setBounds(180,240,50,40);
        na.setBounds(250,240,50,40);

        mg.setBounds(40,310,50,40);
        al.setBounds(110,310,50,40);
        si.setBounds(180,310,50,40);
        p.setBounds(250,310,50,40);

        calculate.setBounds(120,380,100,40);

        add(t);
        add(h);
        add(he);
        add(be);
        add(b);
        add(c);
        add(n);
        add(o);
        add(fluorine);
        add(ne);
        add(na);
        add(mg);
        add(al);
        add(si);
        add(p);
        add(calculate);

        setLayout(null);
        setVisible(true);
        setSize(350,500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
