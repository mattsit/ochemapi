
/**
 * Created by DebbiePao on 11/12/16.
 */
public class Atom {
    private int atomic_num;
    private static int next_id;
    private int id;


    public Atom(int atomic_num) {
        this.atomic_num = atomic_num;
        this.id = Atom.next_id;
        Atom.next_id++;
    }

    /**Gives you a hashcode integer to be used for a HashMap.
     *
     * @return Hashcode Integer
     *
     */
    public int hashCode() {
        return this.atomic_num;
    }

    /** Gives you the atomic number of an element.
     *
     * @return Integer atomic number of an element.
     *
     */
    public int getAtomNum() {
        return this.atomic_num;
    }

    /** Gives you the name of the Atom.
     *
     * @return String name of the atom.
     *
     */

    public String getAtomName() {
        return Atom.atom_data[this.atomic_num][0];
    }

    /** Gives you the symbol of the Atom.
     *
     * @return String symbol of the atom.
     *
     */

    public String getAtomSymbol() {
        return Atom.atom_data[this.atomic_num][1];
    }

    /** Checks to see if the two atoms are identical in that they have the same atomic number and
     * if they are the same object.
     *
     * @param a1 first Atom
     * @param a2 second Atom
     * @return Boolean True or False whether two atoms are identical.
     */

    public static boolean equals(Atom a1, Atom a2) {
        return a1.id == a2.id
                && a1.atomic_num == a2.atomic_num;
    }

    /** Checks to see if the two atoms have the same atomic number.
     *
     * @param a1 first Atom
     * @param a2 second Atom
     * @return Boolean True or False whether the two atoms have the same atomic number.
     */

    public static boolean isEquivalent(Atom a1, Atom a2) {
        return a1.atomic_num == a2.atomic_num;
    }

    /** String representation of the Atom.
     *
     * @return String representing the Atom.
     */
    @Override
    public String toString() {
        return "(" + getAtomSymbol() + ")";
    }

    /** Stores all the data for the atoms in the periodic table.
     *
     */
    private static String[][] atom_data = {
        {"Undefined", "XX"},
        {"Hydrogen", "H"},      // 1
        {"Helium", "He"},       // 2
        {"Lithium", "Li"},      // 3
        {"Beryllium", "Be"},    // 4
        {"Boron", "B"},         // 5
        {"Carbon", "C"},        // 6
        {"Nitrogen", "N"},      // 7
        {"Oxygen", "O"},        // 8
        {"Fluorine", "F"},      // 9
        {"Neon", "Ne"},         // 10
        {"Sodium", "Na"},       // 11
        {"Magnesium", "Mg"},    // 12
        {"Aluminium", "Al"},    // 13
        {"Silicon", "Si"},      // 14
        {"Phosphorus", "P"},    // 15
        {"Sulfur", "S"},        // 16
        {"Chlorine", "Cl"},     // 17
        {"Argon", "Ar"},        // 18
        {"Potassium", "K"},     // 19
        {"Calcium", "Ca"},      // 20
        {"Scandium", "Sc"},     // 21
        {"Titanium", "Ti"},     // 22
        {"Vanadium", "V"},      // 23
        {"Chromium", "Cr"},     // 24
        {"Manganese", "Mn"},    // 25
        {"Iron", "Fe"},         // 26
        {"Cobalt", "Co"},       // 27
        {"Nickel", "Ni"},       // 28
        {"Copper", "Cu"},       // 29
        {"Zinc", "Zn"},         // 30
        {"Gallium", "Ga"},      // 31
        {"Germanium", "Ge"},    // 32
        {"Arsenic", "As"},      // 33
        {"Selenium", "Se"},     // 34
        {"Bromine", "Br"},      // 35
        {"Krypton", "Kr"},      // 36
        {"Rubidium", "Rb"},     // 37
        {"Strontium", "Sr"},    // 38
        {"Yttrium", "Y"},       // 39
        {"Zirconium", "Z"},     // 40
        {"Niobium", "Nb"},      // 41
        {"Molybdenum", "Mo"},   // 42
        {"Technetium", "Tc"},   // 43
        {"Ruthenium", "Ru"},    // 44
        {"Rhodium", "Rh"},      // 45
        {"Palladium", "Pd"},    // 46
        {"Silver", "Ag"},       // 47
        {"Cadmium", "Cd"},      // 48
        {"Indium", "In"},       // 49
        {"Tin", "Sn"},          // 50
        {"Antimony", "Sb"},     // 51
        {"Tellurium", "Te"},    // 52
        {"Iodine", "I"}         // 53
    };
}
