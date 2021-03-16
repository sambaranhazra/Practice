package revision;

public class CaseChangePermutation {
    static void print(String s, String result) {
        if (s.length() == 0) {
            System.out.println(result);
        } else {
            String c = "" + s.charAt(0);
            String rest = s.substring(1);
            String lowerCase = c.toLowerCase();
            String upperCase = c.toUpperCase();
            if (lowerCase.equals(upperCase)) {
                print(rest, result + lowerCase);
            } else {
                print(rest, result + lowerCase);
                print(rest, result + upperCase);
            }
        }
    }

    public static void main(String[] args) {
        print("a1b2", "");
    }
}
