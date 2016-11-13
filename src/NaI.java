/**
 * Created by DebbiePao on 11/12/16.
 */

import java.util.HashMap;

/**
 * NaI reagent reacts similarly to the LiF reagent. It also causes the leaving group to
 * leave the molecule. Then, the I- group attaches onto the molecule.
 *
 * @author Debbie Pao and Mattew Sit
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
     * @return the given action
     *
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

        //Add I
        copy.addAtom(I);
        copy.addBond(C, I);

        return copy;
    }
}
