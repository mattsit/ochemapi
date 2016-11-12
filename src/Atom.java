
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

    public int getAtomNum() {
        return this.atomic_num;
    }

    public String getAtomName() {
        return Atom.atom_data[this.atomic_num][1];
    }

    public String getAtomSymbol() {
        return Atom.atom_data[this.atomic_num][0];
    }

    public static boolean equals(Atom a1, Atom a2) {
        return a1.id == a2.id
                && a1.atomic_num == a2.atomic_num;
    }

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
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Bromine", "Br"},       // 35
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Undefined", "XX"},
        {"Iodine", "I"}           // 53
    };
}
