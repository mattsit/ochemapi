/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * A class that represents the reagent water (H2O).
 */
public class Water extends Reagent {
    Atom o = new Atom(8);
    Atom h = new Atom(1);
    Atom h2 = new Atom(1);

    public Water() {
        Molecule water = new Molecule();
        water.addAtom(o);
        water.addAtom(h);
        water.addAtom(h2);
        water.addBond(o, h);
        water.addBond(o, h2);
    }

    /** Reacts the reagent water with the given molecule.
     *
     * @param m the given molecule
     */
    public Molecule action(Molecule m) {
        Molecule copy = m.copy();

        Atom C = new Atom(6);
        Atom F = new Atom(9);
        Atom Cl = new Atom(17);
        Atom Br = new Atom(35);
        Atom getf = copy.get(F);
        Atom getcl = copy.get(Cl);
        Atom getbr = copy.get(Br);

        //Remove Leaving Group (F, Cl, or Br)
        for (Object a : copy.neighbors(C)) {
            Atom rem = (Atom) a;
            if (getf != null) {
                if (Atom.isEquivalent(rem, F)) {
                    copy.removeAtom(F);
                    break;
                }
            }
            else if (getcl != null) {
                if (Atom.isEquivalent(rem, Cl)) {
                    copy.removeAtom(Cl);
                    break;
                }
            }
            else {
                if (Atom.isEquivalent(rem, Br)) {
                    copy.removeAtom(Br);
                    break;
                }
            }
        }

        //Add OH
        copy.addAtom(o);
        copy.addAtom(h);
        copy.addBond(o, h);
        copy.addBond(C, o);

        return copy;
    }
}
