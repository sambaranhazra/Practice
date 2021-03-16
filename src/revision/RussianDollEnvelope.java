package revision;

import java.util.Arrays;

public class RussianDollEnvelope {
    static int length(int[][] array) {
        int[] result = new int[array.length];
        Arrays.sort(array, (o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        Arrays.fill(result, 1);
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if ((array[i][0] > array[j][0] && array[i][1] > array[j][1]) && result[i] <= result[j])
                    result[i] = result[j] + 1;
            }
        }
        return Arrays.stream(result).max().orElse(1);
    }
}
