/**
 * Created by DebbiePao on 11/12/16.
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class MoleculeTest {
    //alkane
    //double bond
    //benzene

    @Test
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
        assertFalse(water.isStereocenter(o));
    }

    @Test
    public void isDoubleBond() {
        Molecule alkene = new Molecule();
        Atom c = new Atom(6);
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

    @Test
    public void isCyclic() {
        Molecule benzene = new Molecule();
        Atom c = new Atom(6);
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

    @Test
    public void testPCC() {
        Molecule m = new Molecule();

        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom c3 = new Atom(6);
        Atom o = new Atom(8);
        Atom h = new Atom(1);

        m.addAtom(c1);
        m.addAtom(c2);
        m.addAtom(c3);
        m.addAtom(o);
        m.addAtom(h);

        m.addBond(c1, c2);
        m.addBond(c2, c3);
        m.addBond(c2, o);
        m.addBond(o, h);

        Reagent pcc = new PCC();
        pcc.action(m);
    }
}
