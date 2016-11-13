/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * Public class that represents the CH3OH reagent.
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

    public void action(Molecule m) {
        Atom C = new Atom(6);
        Atom F = new Atom(9);
        Atom Cl = new Atom(17);
        Atom Br = new Atom(35);
        Atom c2 = new Atom(6);
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

        //Add OCH3
        m.addAtom(o);
        m.addBond(C, o);
        m.addAtom(c2);
        m.addBond(o, c2);
        m.addAtom(h1);
        m.addBond(c2, h1);
        m.addAtom(h2);
        m.addBond(c2, h2);
        m.addAtom(h3);
        m.addBond(c2, h3);
    }

}
