/**
 * Created by DebbiePao on 11/12/16.
 */
public class MoleculeTest {
    //alkane
    //double bond
    //benzene

    public void isWater() {
        Molecule water = new Molecule();
        Atom o = new Atom(8);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        water.addAtom(o);
        water.addAtom(h);
        water.addAtom(h2);
        water.addBond(o, h);
        water.addBond(o, h2);
    }

    public void isDoubleBond() {
        Molecule alkene = new Molecule();
        Atom c = new Atom(4);
        Atom h = new Atom(1);
        Atom h2 = new Atom(1);
        Atom o = new Atom(8);
        alkene.addAtom(c);
        alkene.addAtom(o);
        alkene.addAtom(h);
        alkene.addAtom(h2);
        alkene.addBond(c, h);
        alkene.addBond(c, h2);
        alkene.addBond(c, o, 2);
    }

    public void isCyclic() {
        Molecule benzene = new Molecule();
        Atom c = new Atom(4);
        Atom h = new Atom(1);
        benzene.addAtom(c);
        benzene.addAtom(h);
        benzene.addBond(c, h);
        benzene.addBond(c, h, 2);
        benzene.addBond(c, h);
        benzene.addBond(c, h, 2);
        benzene.addBond(c, h);
        benzene.addBond(c, h, 2);

    }
}
