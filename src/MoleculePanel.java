import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 11/12/2016.
 */
public class MoleculePanel extends JPanel {

    private Molecule m;

    public MoleculePanel(Molecule m) {
        this.m = m;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 2F).deriveFont(Font.BOLD));

        int x = 30;
        int y = 30;

        for (Atom a : m) {
            g.drawString(a.getAtomSymbol(), x, y);
            x+=20;
            y+=20;
        }
        g.drawLine(10,10,30,30);
        setBackground(new Color(130, 147, 153));
    }
}
