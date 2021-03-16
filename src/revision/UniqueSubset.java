package revision;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubset {
    static Set<String> storage = new HashSet<>();

    static void enumerate(String a, String res) {
        if (a.length() == 0) {
            storage.add("{" + res + "}");
        } else {
            String subString = a.substring(1);
            char c = a.charAt(0);
            enumerate(subString, res);
            enumerate(subString, res + c);
        }
    }

    public static void main(String[] args) {
        enumerate("aadndsnsdnkb", "");
        System.out.println(storage);
    }
}
