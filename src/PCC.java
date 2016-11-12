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
        m.get(new Atom(8)); // Oxygen


        return new Molecule();
    }
}
