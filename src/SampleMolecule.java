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

    public static Molecule bromine() { //test naI or LiF or och3- or ch3oh
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

    public static Molecule ch3oh() { //test ch3oh
        Molecule ans = new Molecule();
        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom c3 = new Atom(6);
        Atom c4 = new Atom(6);
        Atom br = new Atom(35);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom h5 = new Atom(1);
        Atom h6 = new Atom(1);
        Atom h7 = new Atom(1);
        Atom h8 = new Atom(1);
        Atom h9 = new Atom(1);
        ans.addAtom(c1);
        ans.addAtom(c2);
        ans.addBond(c1, c2);
        ans.addAtom(c3);
        ans.addAtom(c4);
        ans.addBond(c2, c3);
        ans.addBond(c3, c4);
        ans.addAtom(br);
        ans.addBond(c3, br);
        ans.addAtom(h);
        ans.addAtom(h2);
        ans.addAtom(h3);
        ans.addBond(h, c1);
        ans.addBond(h2, c1);
        ans.addBond(h3, c1);
        ans.addAtom(h4);
        ans.addAtom(h5);
        ans.addBond(c2, h4);
        ans.addBond(c2, h5);
        ans.addAtom(h6);
        ans.addBond(h6, c3);
        ans.addAtom(h7);
        ans.addAtom(h8);
        ans.addAtom(h9);
        ans.addBond(c4, h7);
        ans.addBond(c4, h8);
        ans.addBond(c4, h9);
        return ans;
    }

}
