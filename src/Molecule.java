/**
 * Created by DebbiePao on 11/12/16.
 */
import java.util.*;
public class Molecule {

    private HashMap<Atom, LinkedList<Bond>> adjLists;
    private HashMap<Atom, Boolean> isVisited;

    // Stereochemistry defines the relative orientation of bonds from an atom.
    private HashMap<Atom, Character> stereochem; // 'X', 'R', or 'S' stereochemistry

    public Molecule() {
        this.adjLists = new HashMap<>();
        this.isVisited = new HashMap<>();
        this.stereochem = new HashMap<>();
    }

    public void addAtom(Atom a) {
        adjLists.put(a, new LinkedList<>());
        isVisited.put(a, false);
        stereochem.put(a, 'X');
    }

    public void addBond(Atom a1, Atom a2) {
        addBond(a1, a2, 1, 'X');
    }

    public void addBond(Atom a1, Atom a2, int bondStrength) {
        addBond(a1, a2, bondStrength, 'X');
    }

    public void addBond(Atom a1, Atom a2, int bondStrength, char stereochem) {
        adjLists.get(a1).add(new Bond(a1, a2, bondStrength));
        adjLists.get(a2).add(new Bond(a2, a1, bondStrength));

        //TODO Check stereochem
    }

    /** Removes the specified bond between the two atoms.
     *
     * @return 1 if success, 0 if fail.
     */
    public int removeBond(Atom a1, Atom a2) {
        for (Bond b1 : adjLists.get(a1)) {
            if (Atom.isEquivalent(b1.getTo(), a2)) {
                adjLists.get(a1).remove(b1);

                for (Bond b2 : adjLists.get(a2)) {
                    if (Atom.isEquivalent(b2.getTo(), a1)) {
                        adjLists.get(a2).remove(b2);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void removeAtom(Atom a) {
        for (Bond b1 : adjLists.get(a)) {
            for (Bond b2 : adjLists.get(b1.getTo())) {
                if (Atom.isEquivalent(b2.getTo(), a)) {
                    adjLists.get(b1.getTo()).remove(b2);
                    break;
                }
            }
        }
        adjLists.remove(a);
        isVisited.remove(a);
        stereochem.remove(a);
    }

    /**
     *
     * @return 1 if success, 0 if fail.
     */
    public int changeBond(Atom a1, Atom a2, int bondStrength) {

        for (Bond b1 : adjLists.get(a1)) {
            if (Atom.isEquivalent(b1.getTo(), a2)) {
                b1.bondStrength = bondStrength;
                for (Bond b2 : adjLists.get(a2)) {
                    if (Atom.isEquivalent(b2.getTo(), a1)) {
                        b2.bondStrength = bondStrength;
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Fetches the instance of the atom located within the molecule equivalent to the argument atom.
     *
     * @param a an atom equivalent to the desired atom from the molecule
     * @return the instance of the requested atom contained within the molecule
     */
    public Atom get(Atom a) {
        for (Atom a2 : adjLists.keySet()) {
            if (Atom.isEquivalent(a, a2))
                return a2;
        }
        return null;
    }

    /**
     * This function is used by addBond() to determine whether storing the stereochemical
     * relationship should be required/is necessary.
     *
     * An atom is a stereocenter in the conext of a molecule if:
     *  - There are 4 atomic groups extending from the atom (no double/triple bonds).
     *  - Each of these groups are nonequivalent/unique.
     */
    public boolean isStereocenter(Atom a) {
        if (adjLists.get(a).size() != 4) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                resetVisited();
                visit(a);
                if (isEquivalentGroup(adjLists.get(a).get(i).getTo(), adjLists.get(a).get(j).getTo()))
                    return false;
            }
        }
        return true;
    }

    /**
     * Sets all atom's visited value to false.
     */
    private void resetVisited() {
        for (Atom a : isVisited.keySet()) {
            isVisited.put(a, false);
        }
    }

    private void visit(Atom a) {
        isVisited.put(a, true);
    }

    private boolean isVisited(Atom a) {
        return isVisited.get(a);
    }

    public boolean isEquivalentGroup(Atom a1, Atom a2) {
        if (Atom.isEquivalent(a1, a2)) {
            return false;
        }

        // This solution will work for most cases but may break for some.
        // Determine equal branches if they have the same atomic weight.

        return getWeight(a1) == getWeight(a2);
    }

    private int getWeight(Atom a) {
        int result = a.getAtomNum();
        visit(a);
        for (Bond b : adjLists.get(a)) {
            if (isVisited(b.getTo())) {
                continue;
            } else {
                result += getWeight(b.getTo());
            }
        }
        return result;
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

        public boolean equals(Bond b) {
            return this.bondStrength == b.bondStrength
                    && Atom.isEquivalent(this.from, b.from)
                    && Atom.isEquivalent(this.to, b.to);
        }
    }
}
