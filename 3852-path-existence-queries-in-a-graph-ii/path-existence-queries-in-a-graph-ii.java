import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }

        int LOG = 18;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] jump = new int[LOG][n];

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (j < i) {
                j = i;
            }

            while (j + 1 < n &&
                   values[j + 1] - values[i] <= maxDiff) {
                j++;
            }

            jump[0][i] = j;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] component = new int[n];
        int id = 0;

        for (int i = 1; i < n; i++) {
            if (values[i] - values[i - 1] > maxDiff) {
                id++;
            }

            component[i] = id;
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int left = pos[queries[q][0]];
            int right = pos[queries[q][1]];

            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }

            if (left == right) {
                answer[q] = 0;
                continue;
            }

            if (component[left] != component[right]) {
                answer[q] = -1;
                continue;
            }

            int distance = 0;
            int current = left;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][current] < right) {
                    current = jump[k][current];
                    distance += (1 << k);
                }
            }

            answer[q] = distance + 1;
        }

        return answer;
    }
}