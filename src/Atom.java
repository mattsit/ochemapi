
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

    /** Gives you a hashcode integer to be used for a HashMap.
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

    public int getValency() {
        return Integer.parseInt(Atom.atom_data[this.atomic_num][3]);
    }

    /** Stores all the data for the atoms in the periodic table.
     *  (Index) Atomic Number
     *  [0] Name
     *  [1] Atomic Symbol
     *  [2] Atomic Weight
     *  [3] Valency
     */
    private static String[][] atom_data = {
        {"Undefined", "XX", "XX", "0"},
        {"Hydrogen", "H", "1.0079", "1"},      // 1
        {"Helium", "He", "4.0026", "2"},       // 2
        {"Lithium", "Li", "6.941", "1"},      // 3
        {"Beryllium", "Be", "9.0122", "2"},    // 4
        {"Boron", "B", "10.811", "3"},         // 5
        {"Carbon", "C", "12.0107", "4"},        // 6
        {"Nitrogen", "N", "14.0067", "3"},      // 7
        {"Oxygen", "O", "15.9994", "2"},        // 8
        {"Fluorine", "F", "18.9984", "1"},      // 9
        {"Neon", "Ne", "20.1797", "0"},         // 10
        {"Sodium", "Na", "22.9897", "1"},       // 11
        {"Magnesium", "Mg", "24.305", "2"},    // 12
        {"Aluminium", "Al", "26.9815", "3"},    // 13
        {"Silicon", "Si", "28.0855", "4"},      // 14
        {"Phosphorus", "P", "30.9738", "5"},    // 15
        {"Sulfur", "S", "32.065", "6"},        // 16
        {"Chlorine", "Cl", "35.453", "0"},     // 17
        {"Argon", "Ar", "39.948", "0"},        // 18
        {"Potassium", "K", "39.0983", "1"},     // 19
        {"Calcium", "Ca", "40.078", "2"},      // 20
        {"Scandium", "Sc", "44.9559", "0"},     // 21
        {"Titanium", "Ti", "47.867", "0"},     // 22
        {"Vanadium", "V", "50.9415", "0"},      // 23
        {"Chromium", "Cr", "51.9961", "0"},     // 24
        {"Manganese", "Mn", "54.938", "0"},    // 25
        {"Iron", "Fe", "55.845", "0"},         // 26
        {"Cobalt", "Co", "58.9332", "0"},       // 27
        {"Nickel", "Ni", "58.6934", "0"},       // 28
        {"Copper", "Cu", "63.546", "0"},       // 29
        {"Zinc", "Zn", "65.39", "0"},         // 30
        {"Gallium", "Ga", "69.723", "3"},      // 31
        {"Germanium", "Ge", "72.64", "4"},    // 32
        {"Arsenic", "As", "74.9216", "5"},      // 33
        {"Selenium", "Se", "78.96", "6"},     // 34
        {"Bromine", "Br", "79.904", "0"},      // 35
        {"Krypton", "Kr", "83.8", "0"},      // 36
        {"Rubidium", "Rb", "85.4678", "1"},     // 37
        {"Strontium", "Sr", "87.62", "2"},    // 38
        {"Yttrium", "Y", "88.9059", "0"},       // 39
        {"Zirconium", "Z", "91.224", "0"},     // 40
        {"Niobium", "Nb", "92.9064", "0"},      // 41
        {"Molybdenum", "Mo", "95.94", "0"},   // 42
        {"Technetium", "Tc", "98", "0"},   // 43
        {"Ruthenium", "Ru", "101.07", "0"},    // 44
        {"Rhodium", "Rh", "102.9055", "0"},      // 45
        {"Palladium", "Pd", "106.42", "0"},    // 46
        {"Silver", "Ag", "107.8682", "0"},       // 47
        {"Cadmium", "Cd", "112.411", "0"},      // 48
        {"Indium", "In", "114.818", "3"},       // 49
        {"Tin", "Sn", "118.71", "4"},          // 50
        {"Antimony", "Sb", "121.76", "5"},     // 51
        {"Tellurium", "Te", "127.6", "6"},    // 52
        {"Iodine", "I", "126.9045", "0"}         // 53
    };
}
