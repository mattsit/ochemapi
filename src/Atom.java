
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

    /** Gives you the atomic mass of the element.
     *
     * @return Integer atomic mass of the atom.
     */

    public Integer getAtomicMass() { return Integer.parseInt(Atom.atom_data[this.atomic_num][2]); }

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
        {"Undefined", "XX", "XX"},
        {"Hydrogen", "H", "1.0079"},      // 1
        {"Helium", "He", "4.0026"},       // 2
        {"Lithium", "Li", "6.941"},      // 3
        {"Beryllium", "Be", "9.0122"},    // 4
        {"Boron", "B", "10.811"},         // 5
        {"Carbon", "C", "12.0107"},        // 6
        {"Nitrogen", "N", "14.0067"},      // 7
        {"Oxygen", "O", "15.9994"},        // 8
        {"Fluorine", "F", "18.9984"},      // 9
        {"Neon", "Ne", "20.1797"},         // 10
        {"Sodium", "Na", "22.9897"},       // 11
        {"Magnesium", "Mg", "24.305"},    // 12
        {"Aluminium", "Al", "26.9815"},    // 13
        {"Silicon", "Si", "28.0855"},      // 14
        {"Phosphorus", "P", "30.9738"},    // 15
        {"Sulfur", "S", "32.065"},        // 16
        {"Chlorine", "Cl", "35.453"},     // 17
        {"Argon", "Ar", "39.948"},        // 18
        {"Potassium", "K", "39.0983"},     // 19
        {"Calcium", "Ca", "40.078"},      // 20
        {"Scandium", "Sc", "44.9559"},     // 21
        {"Titanium", "Ti", "47.867"},     // 22
        {"Vanadium", "V", "50.9415"},      // 23
        {"Chromium", "Cr", "51.9961"},     // 24
        {"Manganese", "Mn", "54.938"},    // 25
        {"Iron", "Fe", "55.845"},         // 26
        {"Cobalt", "Co", "58.9332"},       // 27
        {"Nickel", "Ni", "58.6934"},       // 28
        {"Copper", "Cu", "63.546"},       // 29
        {"Zinc", "Zn", "65.39"},         // 30
        {"Gallium", "Ga", "69.723"},      // 31
        {"Germanium", "Ge", "72.64"},    // 32
        {"Arsenic", "As", "74.9216"},      // 33
        {"Selenium", "Se", "78.96"},     // 34
        {"Bromine", "Br", "79.904"},      // 35
        {"Krypton", "Kr", "83.8"},      // 36
        {"Rubidium", "Rb", "85.4678"},     // 37
        {"Strontium", "Sr", "87.62"},    // 38
        {"Yttrium", "Y", "88.9059"},       // 39
        {"Zirconium", "Z", "91.224"},     // 40
        {"Niobium", "Nb", "92.9064"},      // 41
        {"Molybdenum", "Mo", "95.94"},   // 42
        {"Technetium", "Tc", "98"},   // 43
        {"Ruthenium", "Ru", "101.07"},    // 44
        {"Rhodium", "Rh", "102.9055"},      // 45
        {"Palladium", "Pd", "106.42"},    // 46
        {"Silver", "Ag", "107.8682"},       // 47
        {"Cadmium", "Cd", "112.411"},      // 48
        {"Indium", "In", "114.818"},       // 49
        {"Tin", "Sn", "118.71"},          // 50
        {"Antimony", "Sb", "121.76"},     // 51
        {"Tellurium", "Te", "127.6"},    // 52
        {"Iodine", "I", "126.9045"}         // 53
    };
}
