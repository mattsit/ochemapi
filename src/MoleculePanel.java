import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

        int x = 100;
        int y = 100;
        int dx = 30;
        int dy = 30;

        PriorityQueue<Integer> fringe = new PriorityQueue<>();
        ArrayList<Atom> visited = new ArrayList<>();
        int curr = 0;

        //setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59)));

        for (Atom a : m) {
            visited.add(a);
            int numNeighbors = 0;
            for (Object o : m.neighbors(a)) {
                if (visited.contains(o))
                    numNeighbors--;
                if (m.getBond())
            }
            fringe.add(a.getValency() + numNeighbors);

            while (curr == 0) {
                curr = fringe.poll();
                if (fringe.isEmpty())
                    break;
            }
            if (curr == 4) {
                dx = -dx;
            } else if (curr == 3) {
                dy = -dy;
            } else if (curr == 2) {
                dx = -dx;
            } else {
                dy = -dy;
            }

            curr--;
            if (!fringe.isEmpty() || curr > -1) {
                g.setColor(new Color(59, 59, 59));
                ((Graphics2D)g).setStroke(new BasicStroke(4F));
                g.drawLine(x + 10, y - 10, x + dx + 10, y + dy - 10);
            }

            g.setColor(new Color(224, 211, 132));
            g.fillRoundRect(x,y-20,20,20,5,5);
            g.setColor(new Color(115, 115, 115));
            g.drawString(a.getAtomSymbol(), x, y);


            x+=dx;
            y+=dy;
        }

        setBackground(new Color(130, 147, 153));
    }
}
