package revision;

public class TowerOfHanoi {
    static void move(int n, char source, char dest, char helper) {
        if (n > 1) {
            move(n - 1, source, helper, dest);
            System.out.println("Move disk " + n + " from " + source + " to " + dest);
            move(n - 1, helper, dest, source);
        } else
            System.out.println("Move disk " + n + " from " + source + " to " + dest);
    }

    public static void main(String[] args) {
        move(10, 'A', 'B', 'H');
    }
}
