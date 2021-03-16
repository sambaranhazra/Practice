package revision;

public class SpacePermutation {
    static boolean isFirst = true;

    static void print(String s, String result) {
        if (s.length() == 0) {
            System.out.println(result);
        } else {
            if (!isFirst) {
                print(s.substring(1), result + " " + s.charAt(0));
            }
            isFirst = false;
            print(s.substring(1), result + s.charAt(0));
        }
    }

    public static void main(String[] args) {
        print("abcd", "");
    }
}
