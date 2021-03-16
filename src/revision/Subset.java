package revision;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Subset {
    static Set<String> enumerate(String s, int n) {
        if (n < 1)
            return new HashSet<>();
        if (n == 1) {
            HashSet<String> strings = new HashSet<>();
            strings.add("{}");
            strings.add("{" + s.charAt(0) + "}");
            return strings;
        }
        char c = s.charAt(n - 1);
        Set<String> enumerate = enumerate(s, n - 1);
        Set<String> s1 = enumerate.stream().map(k -> "{" + k.substring(1, k.length() - 1) + "}").collect(Collectors.toSet());
        Set<String> s2 = enumerate.stream().map(k -> "{" + k.substring(1, k.length() - 1) + c + "}").collect(Collectors.toSet());
        s1.addAll(s2);
        return s1;
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(String.join(",", enumerate(str, str.length()).stream().sorted().collect(Collectors.toCollection(TreeSet::new))));
    }
}