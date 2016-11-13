/**
 * Created by DebbiePao on 11/12/16.
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

        //Add OH
        m.addAtom(o);
        m.addAtom(h);
        m.addBond(o, h);
        m.addBond(C, o);
    }
}
