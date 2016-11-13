/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * Class that represents the LiF reagent.
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
     */
    public void action(Molecule m) {
        Atom C = new Atom(6);
        Atom F = new Atom(9);
        Atom Cl = new Atom(17);
        Atom Br = new Atom(35);
        Atom getf = m.get(F);
        Atom getcl = m.get(Cl);
        Atom getbr = m.get(Br);

        //Remove Leaving Group (F, Cl, or Br)
        for (Object a : m.neighbors(C)) {
            Atom rem = (Atom) a;
            if (getf != null) {
                if (Atom.isEquivalent(rem, F)) {
                    m.removeAtom(F);
                    break;
                }
            }
            else if (getcl != null) {
                if (Atom.isEquivalent(rem, Cl)) {
                    m.removeAtom(Cl);
                    break;
                }
            }
            else {
                if (Atom.isEquivalent(rem, Br)) {
                    m.removeAtom(Br);
                    break;
                }
            }
        }

        //Add F
        m.addAtom(F);
        m.addBond(C, F);

    }
}
