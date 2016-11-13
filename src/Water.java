/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * Water is a weak attacker so the leaving groups leaves first, thus forming an alcohol
 * group where the leaving group was before.
 *
 * @author Debbie Pao and Matthew Sit
 *
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
     * @return the molecule after it has reacted with the reagent water.
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
        Atom lg = copy.get(F);
        if (lg == null)
            lg = copy.get(Cl);
        if (lg == null)
            lg = copy.get(Br);
        Atom copyC = new Atom(0);
        boolean flag = false;
        for (Object o : copy.neighbors(lg)) {
            if (Atom.isEquivalent((Atom)o, C)) {
                copyC = (Atom) o;
                flag = true;
                break;
            }
        }
        if (!flag)
            return null;

        copy.removeAtom(lg);

        //Add OH
        copy.addAtom(o);
        copy.addAtom(h);
        copy.addBond(o, h);
        copy.addBond(copyC, o);

        return copy;
    }
}
