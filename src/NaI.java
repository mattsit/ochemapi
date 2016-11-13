/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * Class that represents the NaI reagent.
 */
public class NaI extends Reagent {

    private Atom I = new Atom(53);
    public NaI() {
        Molecule nai = new Molecule();
        Atom Na = new Atom(11);
        nai.addAtom(Na);
        nai.addAtom(I);
        nai.addBond(Na, I);
    }

    /** Reacts the NaI reagent with the given molecule.
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

        //Add I
        m.addAtom(I);
        m.addBond(C, I);

    }
}
