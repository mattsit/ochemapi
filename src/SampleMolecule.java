/**
 * Created by Matthew on 11/13/2016.
 */
public class SampleMolecule {

    public static Molecule alcohol() {
        Molecule alcohol = new Molecule();
        Atom c = new Atom(6);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom o = new Atom(8);
        alcohol.addAtom(c);
        alcohol.addAtom(o);
        alcohol.addAtom(h);
        alcohol.addAtom(h2);
        alcohol.addAtom(h3);
        alcohol.addAtom(h4);
        alcohol.addBond(c, h);
        alcohol.addBond(c, h2);
        alcohol.addBond(c, h3);
        alcohol.addBond(c, o);
        alcohol.addBond(h4, o);

        return alcohol;
    }

    public static Molecule bromine() {
        Molecule bromine = new Molecule();
        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom br = new Atom(35);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom h5 = new Atom(1);
        bromine.addAtom(c1);
        bromine.addAtom(c2);
        bromine.addBond(c1, c2);
        bromine.addBond(c1, br);
        bromine.addAtom(h);
        bromine.addAtom(h2);
        bromine.addAtom(h3);
        bromine.addAtom(h4);
        bromine.addAtom(h5);
        bromine.addBond(c1, h);
        bromine.addBond(c1, h2);
        bromine.addBond(c2, h3);
        bromine.addBond(c2, h4);
        bromine.addBond(c2, h5);
        return bromine;

    }

}
