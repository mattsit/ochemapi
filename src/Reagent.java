/**
 * Created by DebbiePao on 11/12/16.
 */
import java.util.*;
public abstract class Reagent extends Molecule {



    public Molecule action(Reagent r) {
        return r.Action();
    }

    public Molecule Action() {
        return new Molecule();
    }
}
