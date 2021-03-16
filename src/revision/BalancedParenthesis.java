package revision;

import java.util.ArrayList;
import java.util.List;

public class BalancedParenthesis {
    static List<String> values = new ArrayList<>();

    static void generate(int open, int close, String res) {
        if (open == 0 && close == 0) values.add(res);
        if (open > 0)
            generate(open - 1, close, res + "(");
        if (open < close)
            generate(open, close - 1, res + ")");
    }

    public static void main(String[] args) {
        int num = 3;
        generate(num, num, "");
        System.out.println(values);
    }
}
