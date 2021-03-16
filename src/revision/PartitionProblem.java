package revision;

import java.util.Arrays;

public class PartitionProblem {
    static int partition(int[] books, int students) {
        int start = Arrays.stream(books).max().orElse(0);
        int end = Arrays.stream(books).sum();
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / students;
            if (isValid(books, students, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] books, int students, int maxPages) {
        int stu = 1;
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i];
            if (sum > maxPages) {
                stu++;
                sum = books[i];
            }
            if (stu > students)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] books = new int[]{10, 20, 40, 30, 50, 10, 40, 43, 12};
        System.out.println(partition(books, 4));
    }
}
