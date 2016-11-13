/**
 * Created by DebbiePao on 11/12/16.
 */
public class PCC extends Reagent {

    /**
     * PCC oxidizes alcohols.
     * The Hydrogen is removed from the alcohol and the single bond
     * connecting the former alcohol to a Carbon becomes a double bond.
     *
     */
    public Molecule action(Molecule m) {
        Molecule copy = m.copy();
        Atom oxygen = copy.get(new Atom(8));

        // Remove Oxygen's Hydrogen
        for (Object o : copy.neighbors(oxygen)) {
            Atom a = (Atom)o;
            if (Atom.isEquivalent(a, new Atom(1))) {
                copy.removeAtom(a);
                break;
            }
        }

        // Remove Carbon's Hydrogen
        for (Object o : copy.neighbors(oxygen)) {
            Atom a = (Atom)o;
            if (Atom.isEquivalent(a, new Atom(6))) {
                for (Object o2 : copy.neighbors(oxygen)) {
                    Atom a2 = (Atom)o2;
                    if (Atom.isEquivalent(a2, new Atom(1))) {
                        copy.removeAtom(a2);
                        break;
                    }
                }
                break;
            }
        }

        // Change single bond to double bond between O and C.
        for (Object o : copy.neighbors(oxygen)) {
            Atom a = (Atom)o;
            if (Atom.isEquivalent(a, new Atom(6))) {
                copy.changeBond(a, oxygen, 2);
                break;
            }
        }
        return copy;
    }
}
