import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthew on 11/13/2016.
 */
public class FrameMech extends JFrame {
    private JButton lif = new JButton("LiF");
    private JButton pcc = new JButton("PCC");
    private JButton nai = new JButton("NaI");
    private JButton hoch3 = new JButton("HOCH3");
    private JButton h2o = new JButton("H2O");

    public FrameMech() {
        super("Mechanisms and Molecular Representations");

        lif.setBounds(30,40,90,40);
        pcc.setBounds(130,40,90,40);
        nai.setBounds(230,40,90,40);
        hoch3.setBounds(330,40,90,40);
        h2o.setBounds(430,40,90,40);

        JPanel container1 = new JPanel();
        JPanel container2 = new JPanel();

        JFrame me = this;

        lif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.bromine(), m);
                m.drawAfter(SampleMolecule.bromine(), new LiF(), m);
                m.lif.setBackground(Color.green);
                me.dispose();
            }
        });

        pcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.alcohol(), m);
                m.drawAfter(SampleMolecule.alcohol(), new PCC(), m);
                m.pcc.setBackground(Color.green);
                me.dispose();
            }
        });

        nai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.bromine(), m);
                m.drawAfter(SampleMolecule.bromine(), new NaI(), m);
                m.nai.setBackground(Color.green);
                me.dispose();
            }
        });

        hoch3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.ch3oh(), m);
                m.drawAfter(SampleMolecule.ch3oh(), new CH3OH(), m);
                m.hoch3.setBackground(Color.green);
                me.dispose();
            }
        });

        h2o.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.bromine(), m);
                m.drawAfter(SampleMolecule.bromine(), new Water(), m);
                m.h2o.setBackground(Color.green);
                me.dispose();
            }
        });

        container1.setBounds(30,100,240,240);
        container2.setBounds(280,100,240,240);

        add(lif);
        add(pcc);
        add(nai);
        add(hoch3);
        add(h2o);

        add(container1);
        add(container2);

        setLayout(null);
        setVisible(true);
        setSize(550,400);
        setResizable(false);
    }

    private void drawBefore(Molecule m, JFrame f) {
        JPanel container = new MoleculePanel(m);
        container.setBounds(30,100,240,240);
        f.add(container);
        f.setSize(f.getWidth(), f.getHeight()+1);
        f.setSize(f.getWidth(), f.getHeight()-1);
    }

    private void drawAfter(Molecule m, Reagent r, JFrame f) {
        JPanel container = new MoleculePanel(r.action(m));
        container.setBounds(280,100,240,240);
        f.add(container);
        f.setSize(f.getWidth(), f.getHeight()+1);
        f.setSize(f.getWidth(), f.getHeight()-1);
    }
}
