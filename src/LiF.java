/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * LiF is a strong reagent that causes the leaving groups to leave. Then it attaches to the molecule.
 * The leaving group (F, Cl, Br, or I) is removed from the molecule and the F- group attaches
 * on to the molecule where the leaving group was.
 *
 * @author Debbie Pao and Matthew Sit
 */
public class LiF extends Reagent {

    private Atom F = new Atom(9);
    public LiF() {
        Molecule lif = new Molecule();
        Atom Li = new Atom(3);
        lif.addAtom(Li);
        lif.addAtom(F);
        lif.addBond(Li, F);
    }

    /** Reacts LiF with the given molecule.
     *
     * @param m the given molecule
     * @return the molecule after it has reacted with the reagent
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
        for (Object a : copy.neighbors(copy.get(C))) {
            Atom rem = (Atom) a;
            if (getf != null) {
                if (Atom.isEquivalent(rem, F)) {
                    copy.removeAtom(rem);
                    break;
                }
            }
            else if (getcl != null) {
                if (Atom.isEquivalent(rem, Cl)) {
                    copy.removeAtom(rem);
                    break;
                }
            }
            else {
                if (Atom.isEquivalent(rem, Br)) {
                    copy.removeAtom(rem);
                    break;
                }
            }
        }

        //Add F
        copy.addAtom(F);
        copy.addBond(copy.get(C), F);
        return copy;
    }
}
