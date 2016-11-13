import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/13/2016.
 */
public class FrameMech extends JFrame {

    public FrameMech() {
        super("Mechanisms and Molecular Representations");

        JButton btnGenerate = new JButton("React!");
        btnGenerate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton lif = new JButton("LiF");
        JButton ch3oh = new JButton("CH3OH");
        JButton nai = new JButton("NaI");
        JButton och3 = new JButton("OCH3");
        JButton h2o = new JButton("H2O");

        lif.setBounds(30,40,90,40);
        ch3oh.setBounds(130,40,90,40);
        nai.setBounds(230,40,90,40);
        och3.setBounds(330,40,90,40);
        h2o.setBounds(430,40,90,40);

        JPanel container1 = new MoleculePanel(SampleMolecule.alcohol());
        JPanel container2 = new MoleculePanel((new PCC()).action(SampleMolecule.alcohol()));

        container1.setBounds(30,100,240,240);
        container2.setBounds(280,100,240,240);

        add(lif);
        add(ch3oh);
        add(nai);
        add(och3);
        add(h2o);

        add(container1);
        add(container2);


        setLayout(null);
        setVisible(true);
        setSize(550,500);
        setResizable(false);
    }

}
