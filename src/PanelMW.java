import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/13/2016.
 */
public class PanelMW extends JFrame {

    private int[] counts;

    public PanelMW() {
        super("Molecular Weight Calculator");

        counts = new int[18];

        JTextField t = new JTextField();
        t.setEditable(false);

        JButton calculate = new JButton("Calculate!");
        JButton clear = new JButton("Clear");
        JButton h = new JButton("H");
        JButton he = new JButton("He");
        JButton li = new JButton("Li");
        JButton be = new JButton ("Be");
        JButton b = new JButton("B");
        JButton c = new JButton("C");
        JButton n = new JButton("N");
        JButton o = new JButton("O");
        JButton f = new JButton("F");
        JButton ne = new JButton("Ne");
        JButton na = new JButton("Na");
        JButton mg = new JButton("Mg");
        JButton al = new JButton("Al");
        JButton si = new JButton("Si");
        JButton p = new JButton("P");

        t.setBounds(30,40,280,30);
        h.setBounds(30,100,70,40);
        he.setBounds(100,100,70,40);
        li.setBounds(170,100,70,40);

        be.setBounds(30,170,70,40);
        b.setBounds(100,170,70,40);
        c.setBounds(170,170,70,40);
        n.setBounds(240,170,70,40);

        o.setBounds(30,240,70,40);
        f.setBounds(100,240,70,40);
        ne.setBounds(170,240,70,40);
        na.setBounds(240,240,70,40);

        mg.setBounds(30,310,70,40);
        al.setBounds(100,310,70,40);
        si.setBounds(170,310,70,40);
        p.setBounds(240,310,70,40);

        calculate.setBounds(50,380,100,40);
        clear.setBounds(190,380,100,40);

        h.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[1]++;
                h.setText("H (" + counts[1] + ")");
            }
        });

        he.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[2]++;
                he.setText("He (" + counts[2] + ")");
            }
        });

        li.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[3]++;
                li.setText("Li (" + counts[3] + ")");
            }
        });

        be.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[4]++;
                be.setText("Be (" + counts[4] + ")");
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[5]++;
                b.setText("B (" + counts[5] + ")");
            }
        });

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[6]++;
                c.setText("C (" + counts[6] + ")");
            }
        });

        n.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[7]++;
                n.setText("N (" + counts[7] + ")");
            }
        });

        o.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[8]++;
                o.setText("O (" + counts[8] + ")");
            }
        });

        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[9]++;
                f.setText("F (" + counts[9] + ")");
            }
        });

        ne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[10]++;
                ne.setText("Ne (" + counts[10] + ")");
            }
        });

        na.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[11]++;
                na.setText("Na(" + counts[11] + ")");
            }
        });

        mg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[12]++;
                mg.setText("Mg (" + counts[12] + ")");
            }
        });

        al.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[13]++;
                al.setText("Al (" + counts[13] + ")");
            }
        });

        si.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[14]++;
                si.setText("Si (" + counts[14] + ")");
            }
        });

        p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counts[15]++;
                p.setText("P (" + counts[15] + ")");
            }
        });

        JFrame me = this;
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PanelMW();
                me.dispose();
            }
        });

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(Double.toString(calculate()));
            }
        });

        add(t);
        add(h);
        add(he);
        add(be);
        add(b);
        add(c);
        add(n);
        add(o);
        add(f);
        add(ne);
        add(na);
        add(mg);
        add(al);
        add(si);
        add(p);
        add(calculate);
        add(clear);

        setLayout(null);
        setVisible(true);
        setSize(350,500);
        setResizable(false);
    }

    private double calculate() {
        double result = 0;
        for (int i = 1; i < counts.length; i++) {
            Atom a = new Atom(i);
            result += counts[i]*a.getAtomicMass();
        }
        return result;
    }
}
