/**
 * Created by DebbiePao on 11/12/16.
 */
import java.util.*;

/**
 * Class that represents a molecule.
 * @author Debbie Pao and Matthew Sit
 */
public class Molecule implements Iterable<Atom> {

    private HashMap<Atom, LinkedList<Bond>> adjLists;
    private HashMap<Atom, Boolean> isVisited;

    // Stereochemistry defines the relative orientation of bonds from an atom.
    private HashMap<Atom, Character> stereochem; // 'X', 'R', or 'S' stereochemistry

    public Molecule() {
        this.adjLists = new HashMap<>();
        this.isVisited = new HashMap<>();
        this.stereochem = new HashMap<>();
    }

    /** Returns the atomic weight of a molecule.
     *
     * @return Double atomic weight of a molecule.
     */
    public double atomicWeight() {
        double ans = 0.0;
        for (Object o : adjLists.keySet()) {
            Atom a = (Atom) o;
            ans += a.getAtomicMass();
        }
        return ans;
    }

    /** Returns a copy of this molecule.
     *
     * @return a copy of this molecule.
     */

    public Molecule copy() {
        Molecule result = new Molecule();
        copyAdjLists(result);
        copyIsVisited(result);
        copyStereochem(result);
        return result;
    }

    /** Makes a copy of the given molecule's list of neighboring atoms.
     *
     * @param m the given molecule.
     */

    private void copyAdjLists(Molecule m) {
        m.adjLists = (HashMap<Atom, LinkedList<Bond>>)adjLists.clone();
        for (Atom a : adjLists.keySet()) {
            LinkedList<Bond> copy = new LinkedList<>();
            for (Bond b : adjLists.get(a)) {
                copy.add(b.copy());
            }
            m.adjLists.put(a, copy);
        }
    }

    /** Makes a copy of which atoms have already been visited for the given molecule.
     *
     * @param m the given molecule.
     */

    private void copyIsVisited(Molecule m) {
        m.isVisited = (HashMap<Atom, Boolean>)isVisited.clone();
    }

    /** Makes a copy of the sterochemistry of the given molecule.
     *
     * @param m the given molecule.
     */

    private void copyStereochem(Molecule m) {
        m.stereochem = (HashMap<Atom, Character>)stereochem.clone();
    }

    /** Adds an atom the molecule.
     *
     * @param a Atom to be added to the molecule.
     */

    public void addAtom(Atom a) {
        adjLists.put(a, new LinkedList<>());
        isVisited.put(a, false);
        stereochem.put(a, 'X');
    }

    /** Adds a single bond to the molecule between the two specified atoms.
     *
     * @param a1 first atom in single bond
     * @param a2 second atom in single bond
     */
    public void addBond(Atom a1, Atom a2) {
        addBond(a1, a2, 1, 'X');
    }

    /** Adds a single, double, or triple bond to the molecule between the two specified atoms.
     *
     * @param a1 first atom in the bond
     * @param a2 second atom in the bond
     * @param bondStrength denotes single, double, or triple bond
     */

    public void addBond(Atom a1, Atom a2, int bondStrength) {
        addBond(a1, a2, bondStrength, 'X');
    }

    /** Adds a single, double, or triple bond to the molecule between the two specified atoms
     * with sterochemistry taken into account.
     *
     * @param a1 first atom
     * @param a2 second atom
     * @param bondStrength single, double, or triple bond
     * @param stereochem wedged or dashed
     */
    public void addBond(Atom a1, Atom a2, int bondStrength, char stereochem) {
        adjLists.get(a1).add(new Bond(a1, a2, bondStrength));
        adjLists.get(a2).add(new Bond(a2, a1, bondStrength));

        //TODO Check stereochem
    }

    /** Removes the specified bond between the two atoms.
     * @param a1 first atom
     * @param a2 second atom
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

    /** Removes the atom from the molecule.
     *
     * @param a the atom to be removed
     */
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

    /** Changes the bond strength.
     *
     * @param a1 first atom
     * @param a2 second atom
     * @param bondStrength the strength of the bond (whether single, double, or triple)
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

    /** Checks to see if the two molecules are identical.
     *
     * @param m1 first molecule
     * @param m2 second molecule
     * @return True if is equal, False if not.
     */

    public boolean isEqual(Molecule m1, Molecule m2) {
        for (Object o: m1.adjLists.keySet()) {
            for (Object a : m2.adjLists.keySet()) {
                Atom o2 = (Atom) o;
                Atom a2 = (Atom) a;
                if (!Atom.equals(o2, a2)) {
                    return false;
                }
            }
        }
        return true;
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
     *
     *  @param a the atom
     *  @return True if is a stereocenter, False if not
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

    /** Keeps track of whether the atom has been visited before.
     *
     * @param a Atom that has been visited.
     */

    private void visit(Atom a) {
        isVisited.put(a, true);
    }

    /** Checks whether an Atom has been visited or not previously.
     *
     * @param a the atom that is checked to see if has been visited.
     * @return True if has been visited, False if has not.
     */

    private boolean isVisited(Atom a) {
        return isVisited.get(a);
    }

    /** Checks to see if two parts of a molecule are the same.
     *
     * @param a1 first part of molecule
     * @param a2 second part of molecule
     * @return True if equivalent, False if not.
     */

    private boolean isEquivalentGroup(Atom a1, Atom a2) {
        if (Atom.isEquivalent(a1, a2)) {
            return false;
        }

        // This solution will work for most cases but may break for some.
        // Determine equal branches if they have the same atomic weight.

        return getWeight(a1) == getWeight(a2);
    }

    /** Finds the total atomic number of the molecule.
     *
     * @param a starting atom
     * @return Integer total atomic number
     */

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

    /** Finds if there is a bond from one atom to the other.
     *
     * @param from the first atom
     * @param to second atom
     * @return True if there is a bond, False if none
     */
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

    /** Get the neighboring atoms of the current atom in a molecule.
     *
     * @param a the current atom
     * @return a list of all the neighboring atoms
     */

    public List neighbors(Atom a) {
        ArrayList<Atom> result = new ArrayList<>();
        for (int i = 0; i < adjLists.get(a).size(); i++) {
            result.add(adjLists.get(a).get(i).getTo());
        }
        return result;
    }

    /** Getter method to find the bond strength between two given atoms.
     *
     * @param a1 first atom
     * @param a2 second atom
     * @return Integer bond Strength the bond between the two atoms.
     */

    public int getBondStrength(Atom a1, Atom a2) {
        for (Bond b : adjLists.get(a1)) {
            if (Atom.equals(b.getTo(), a2)) {
                return b.getBondStrength();
            }
        }
        return 0;
    }

    /**
     * Private class that describes the bonds in a molecule.
     */

    private class Bond {
        private Atom from;
        private Atom to;
        private int bondStrength;

        public Bond(Atom from, Atom to, int bondStrength) {
            this.from = from;
            this.to = to;
            this.bondStrength = bondStrength;
        }

        /** Returns one atom that is sharing the bond.
         *
         * @return an Atom
         */

        public Atom getFrom() {
            return this.from;
        }

        /** Returns the other atom that is sharing the bond.
         *
         * @return an Atom
         */

        public Atom getTo() {
            return this.to;
        }

        /** Returns the bond strength of the bond.
         *
         * @return Integer bond strength
         */

        public int getBondStrength() {
            return this.bondStrength;
        }

        /** Checks whether one bond strength is equal to another bond strength.
         *
         * @param b the other bond your are comparing this bond to.
         * @return True if equal, False if not equal.
         */

        public boolean equals(Bond b) {
            return this.bondStrength == b.bondStrength
                    && Atom.equals(this.from, b.from)
                    && Atom.equals(this.to, b.to);
        }

        /** Copies the bond.
         *
         * @return a copy of the bond.
         */
        public Bond copy() {
            return new Bond(from, to, bondStrength);
        }
    }

    /** Returns an Iterator.
     *
     * @return an Iterator
     */

    public Iterator<Atom> iterator() {
        return new DFSIterator();
    }

    /**
     * Creates a Depth-First Iterator.
     */

    private class DFSIterator implements Iterator<Atom> {

        private Stack<Atom> fringe;
        private HashSet<Atom> visited;

        public DFSIterator() {
            fringe = new Stack<>();
            visited = new HashSet<>();
            Atom start = adjLists.keySet().iterator().next();
            fringe.add(start);
            visited.add(start);
        }

        public boolean hasNext() {
            if (!fringe.isEmpty()) {
                return true;
            }
            return false;
        }

        public Atom next() {
            Atom curr = fringe.pop();
            List children = neighbors(curr);
            for (Object o : children) {
                Atom a = (Atom)o;
                if (!visited.contains(a)) {
                    fringe.add(a);
                    visited.add(a);
                }
            }
            return curr;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
