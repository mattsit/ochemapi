/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * CH3OH causes the leaving groups to leave first and then it attaches to the molecule. The
 * leaving group (F, Cl, Br, or I) is removed from the molecule and the OCH3 group attaches
 * on to the molecule where the leaving group was.
 *
 * @author Debbie Pao and Matthew Sit
 */
public class CH3OH extends Reagent {
    Molecule ch3oh = new Molecule();
    Atom c = new Atom(6);
    Atom h1 = new Atom(1);
    Atom h2 = new Atom(1);
    Atom h3 = new Atom(1);
    Atom h4 = new Atom(1);
    Atom o = new Atom(8);

    public CH3OH() {
        ch3oh.addAtom(o);
        ch3oh.addAtom(c);
        ch3oh.addBond(c, o);
        ch3oh.addAtom(h1);
        ch3oh.addAtom(h2);
        ch3oh.addAtom(h3);
        ch3oh.addBond(c, h1);
        ch3oh.addBond(c, h2);
        ch3oh.addBond(c, h3);
        ch3oh.addAtom(h4);
        ch3oh.addBond(o, h4);
    }

    /** Reacts CH3OH reagent with the given molecule.
     *
     * @param m the given molecule
     * @return Molecule after reaction happens
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

        //Add OCH3
        copy.addAtom(o);
        copy.addBond(copyC, o);
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
