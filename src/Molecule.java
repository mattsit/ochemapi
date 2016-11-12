/**
 * Created by DebbiePao on 11/12/16.
 */
import java.util.*;
public class Molecule {
    private HashMap<Atom, LinkedList<Bond>> adjLists;

    public Molecule() {
        this.adjLists = new HashMap<>();
    }

    public void addAtom(Atom a) {
        adjLists.put(a, new LinkedList<>());
    }

    public void addBond(Atom a1, Atom a2) {
        addBond(a1, a2, 1);
    }

    public void addBond(Atom a1, Atom a2, int bondStrength) {
        adjLists.get(a1).add(new Bond(a1, a2, bondStrength));
        adjLists.get(a2).add(new Bond(a2, a1, bondStrength));
    }

    // Return true if there is an Bond from Atom "from" to Atom "to";
    // return false otherwise.
    public boolean isAdjacent(Atom from, Atom to) {
        for (Object a : neighbors(from)) {
            if (a.equals(to)) {
                return true;
            }
        }
        return false;
    }

    public List neighbors(Atom a) {
        ArrayList<Atom> result = new ArrayList<>();
        for (int i = 0; i < adjLists.get(a).size(); i++) {
            result.add(adjLists.get(a).get(i).getTo());
        }
        return result;
    }

    private class Bond {
        private Atom from;
        private Atom to;
        private int bondStrength;

        public Bond(Atom from, Atom to, int bondStrength) {
            this.from = from;
            this.to = to;
            this.bondStrength = bondStrength;
        }

        public Atom getFrom() {
            return this.from;
        }

        public Atom getTo() {
            return this.to;
        }

        public int getBondStrength() {
            return this.bondStrength;
        }
    }
}
