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
                m.drawDescription("LiF- performs a reaction called SN2 on the molecule where the leaving group (usually F, Cl, Br, or I) leaves and the F- joins the now broken molecule.",m);
                me.dispose();
            }
        });

        pcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.alcohol(), m);
                m.drawAfter(SampleMolecule.alcohol(), new PCC(), m);
                m.pcc.setBackground(Color.green);
                m.drawDescription("PCC- This is a special reagent that reacts with a molecule that changes all alcohol groups (OH groups) into an O double bonded to a carbon.",m);
                me.dispose();
            }
        });

        nai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.bromine(), m);
                m.drawAfter(SampleMolecule.bromine(), new NaI(), m);
                m.nai.setBackground(Color.green);
                m.drawDescription("NaI- Similar to LiF. SN2 is performed on the molecule where the leaving group (usually F, Cl, Br, or I) leaves and the F- joins the now broken molecule.",m);
                me.dispose();
            }
        });

        hoch3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.ch3oh(), m);
                m.drawAfter(SampleMolecule.ch3oh(), new CH3OH(), m);
                m.hoch3.setBackground(Color.green);
                m.drawDescription("CH3OH- causes Sn1 since weak attacker so leaving group leaves first an then OCH3 group attaches onto place the group left.", m);
                me.dispose();
            }
        });

        h2o.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameMech m = new FrameMech();
                m.drawBefore(SampleMolecule.bromine(), m);
                m.drawAfter(SampleMolecule.bromine(), new Water(), m);
                m.h2o.setBackground(Color.green);
                m.drawDescription("Water- causes the leaving group to leave and an alcohol group to take the place of the group that left.", m);
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
        setSize(550,600);
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

    private void drawDescription(String s, JFrame f) {
        JPanel container = new JPanel();
        JTextArea a = new JTextArea(s,5, 30);
        a.setEditable(false);
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        a.setBackground(null);
        container.add(a);
        container.setBounds(30,360,490,300);

        f.add(container);
        f.setSize(f.getWidth(), f.getHeight()+1);
        f.setSize(f.getWidth(), f.getHeight()-1);
    }
}
