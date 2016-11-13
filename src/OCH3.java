/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * OCH3- reagent attacks to the molecule and causes the leaving group (F, Cl, Br, I) to leave
 * and then attaches to the part of the molecule where the leaving group was.
 *
 * @author Debbie Pao and Matt Sit
 */
public class OCH3 extends Reagent {

    Molecule och3 = new Molecule();
    Atom c = new Atom(6);
    Atom h1 = new Atom(1);
    Atom h2 = new Atom(1);
    Atom h3 = new Atom(1);
    Atom o = new Atom(8);

    public OCH3() {
        och3.addAtom(o);
        och3.addAtom(c);
        och3.addBond(c, o);
        och3.addAtom(h1);
        och3.addAtom(h2);
        och3.addAtom(h3);
        och3.addBond(c, h1);
        och3.addBond(c, h2);
        och3.addBond(c, h3);
    }

    /** Reacts reagent OCH3- with the molecule m.
     *
     * @param m molecule to be reacted with.
     * @return the new molecule after it has reacted with the reagent.
     */
    public Molecule action(Molecule m) {
        Molecule copy = m.copy();

        Atom C = new Atom(6);
        Atom F = new Atom(9);
        Atom Cl = new Atom(17);
        Atom Br = new Atom(35);
        Atom c2 = new Atom(6);
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

        //Add OCH3
        copy.addAtom(o);
        copy.addBond(C, o);
        copy.addAtom(c2);
        copy.addBond(o, c2);
        copy.addAtom(h1);
        copy.addBond(c2, h1);
        copy.addAtom(h2);
        copy.addBond(c2, h2);
        copy.addAtom(h3);
        copy.addBond(c2, h3);

        return copy;
    }
}
