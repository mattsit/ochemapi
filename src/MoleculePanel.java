import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by Matthew on 11/12/2016.
 */
public class MoleculePanel extends JPanel {

    private Molecule m;
    private ArrayList<Atom> visited;


    public MoleculePanel(Molecule m) {
        this.m = m;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 2F).deriveFont(Font.BOLD));
        visited = new ArrayList<>();
        drawHelper(g, m.iterator(), 100, 100, 30, 30);
        setBackground(new Color(130, 147, 153));
    }

    private void drawHelper(Graphics g, Iterator mIter, int x, int y, int dx, int dy) {
        //setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59)));

        Atom a = (Atom)mIter.next();
        visited.add(a);
        int numNeighbors = 0;
        int i = 1;
        for (Object o : m.neighbors(a)) {
            if (visited.contains(o))
                numNeighbors--;

            int bondStrength = m.getBondStrength(a, (Atom) o);
            numNeighbors -= bondStrength - 1;

            for (int j = 2; j <= bondStrength; j++) {
                if (visited.contains(o))
                    break;
                if (i == 4) {
                    g.drawLine(x + 6, y - 14, x + dx + 6, y + dy - 14);
                } else if (i == 3) {
                    g.drawLine(x + 6, y - 6, x + dx + 6, y - dy - 6);
                } else if (i == 2) {
                    g.drawLine(x + 14, y - 6, x - dx + 14, y - dy - 6);
                } else if (i == 1) {
                    g.drawLine(x + 14, y - 14, x - dx + 14, y + dy - 14);
                }
            }
            i++;
        }
        int curr = a.getValency() + numNeighbors;

        if (curr >= 4) {
            g.setColor(new Color(59, 59, 59));
            ((Graphics2D) g).setStroke(new BasicStroke(4F));
            g.drawLine(x + 10, y - 10, x - dx + 10, y + dy - 10);
        }

        if (curr >= 3) {
            g.setColor(new Color(59, 59, 59));
            ((Graphics2D) g).setStroke(new BasicStroke(4F));
            g.drawLine(x + 10, y - 10, x - dx + 10, y - dy - 10);
        }

        if (curr >= 2) {
            g.setColor(new Color(59, 59, 59));
            ((Graphics2D) g).setStroke(new BasicStroke(4F));
            g.drawLine(x + 10, y - 10, x + dx + 10, y - dy - 10);
        }

        if (curr >= 1) {
            g.setColor(new Color(59, 59, 59));
            ((Graphics2D) g).setStroke(new BasicStroke(4F));
            g.drawLine(x + 10, y - 10, x + dx + 10, y + dy - 10);
        }

        if (curr == 4) {
            drawHelper(g, mIter, x+dx, y+dy, dx, -dy);
            drawHelper(g, mIter, x+dx, y+dx, -dx, dy);
            drawHelper(g, mIter, x-dx, y+dx, -dx, -dy);
            drawHelper(g, mIter, x+dx, y-dx, dx, dy);
        } else if (curr == 3) {
            drawHelper(g, mIter, x+dx, y+dy, dx, -dy);
            drawHelper(g, mIter, x+dx, y+dx, -dx, dy);
            drawHelper(g, mIter, x-dx, y+dx, -dx, -dy);
        } else if (curr == 2) {
            drawHelper(g, mIter, x+dx, y+dy, dx, -dy);
            drawHelper(g, mIter, x+dx, y+dx, -dx, dy);
        } else if (curr == 1){
            drawHelper(g, mIter, x+dx, y+dy, dx, -dy);
        }

        g.setColor(new Color(224, 211, 132));
        g.fillRoundRect(x - 1, y - 19, 20, 20, 5, 5);
        g.setColor(new Color(115, 115, 115));
        g.drawString(a.getAtomSymbol(), x, y);
    }
}
