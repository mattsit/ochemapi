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
    public void action(Molecule m) {
        Atom oxygen = m.get(new Atom(8));

        // Remove the Hydrogen
        for (Object o : m.neighbors(oxygen)) {
            Atom a = (Atom)o;
            if (Atom.isEquivalent(a, new Atom(1))) {
                m.removeAtom(a);
                break;
            }
        }

        // Change single bond to double bond between O and C.
        for (Object o : m.neighbors(oxygen)) {
            Atom a = (Atom)o;
            if (Atom.isEquivalent(a, new Atom(6))) {
                m.changeBond(a, oxygen, 2);
                break;
            }
        }
    }
}
