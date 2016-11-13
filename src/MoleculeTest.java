/**
 * Created by DebbiePao on 11/12/16.
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class MoleculeTest {

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

    @Test
    public void testNaI() {
        Molecule m = new Molecule();
        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom c3 = new Atom(6);
        Atom i = new Atom(53);
        Atom br = new Atom(35);

        m.addAtom(c1);
        m.addAtom(c2);
        m.addAtom(c3);
        m.addAtom(br);

        Reagent nai = new NaI();
        nai.action(m);
    }

    @Test
    public void testMain() {
        Molecule m = new Molecule();
        Atom si = new Atom(14);
        Atom si2 = new Atom(14);
        Atom c1 = new Atom(6);
        Atom c2 = new Atom(6);
        Atom o = new Atom(8);
        Atom h1 = new Atom(1);
        Atom h2 = new Atom(1);
        Atom h3 = new Atom(1);
        Atom h4 = new Atom(1);
        Atom h5 = new Atom(1);
        Atom h6 = new Atom(1);
        Atom h7 = new Atom(1);
        Atom h8 = new Atom(1);

        m.addAtom(c1);
        m.addAtom(si);
        m.addBond(c1, si);
        m.addAtom(h1);
        m.addBond(c1, h1);
        m.addAtom(c2);
        m.addBond(c1, c2);
        m.addAtom(si2);
        m.addAtom(h2);
        m.addAtom(h3);
        m.addAtom(h4);
        m.addBond(si, h2);
        m.addBond(si, h3);
        m.addBond(si, h4);
        m.addAtom(h5);
        m.addAtom(o);
        m.addBond(si2, h5);
        m.addBond(si2, o, 2);
        m.addAtom(h6);
        m.addAtom(h7);
        m.addAtom(h8);
        m.addBond(c2, h6);
        m.addBond(c2, h7);
        m.addBond(c2, h8);

    }
}
