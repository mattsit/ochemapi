/**
 * Created by DebbiePao on 11/12/16.
 */

/**
 * Abstract Class of all the Reagent Molecules.
 */
public abstract class Reagent extends Molecule {

    /** Abstract method for reacting reagents with the given molecule.
     *
     * @param m the given molecule
     */
    public abstract Molecule action(Molecule m);
}
