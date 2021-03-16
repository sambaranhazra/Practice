package revision;

public class PrintNBitBinaryPrefix {
    static void print(int one, int zero, String res) {
        if (one + zero == 0) {
            System.out.println(res);
        } else {
            if (zero > one) {
                print(one, zero - 1, res + "0");
            }
            print(one - 1, zero, res + "1");
        }
    }


    public static void main(String[] args) {
        int n = 4;
        print((int) Math.ceil(n / 2.0), (int) Math.floor(n / 2.0), "");
    }
}
