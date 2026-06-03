import java.util.*;

class Solution {

    private long solve(int[] startA, int[] durA,
                       int[] startB, int[] durB) {

        int m = startB.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMin = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMin[m - 1] = (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(
                suffixMin[i + 1],
                (long) rides[i][0] + rides[i][1]
            );
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < startA.length; i++) {

            long finishA = (long) startA[i] + durA[i];

            int idx = upperBound(starts, (int) finishA);

            if (idx > 0) {
                ans = Math.min(ans,
                        finishA + prefixMinDur[idx - 1]);
            }

            if (idx < m) {
                ans = Math.min(ans,
                        suffixMin[idx]);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long landToWater = solve(
                landStartTime, landDuration,
                waterStartTime, waterDuration);

        long waterToLand = solve(
                waterStartTime, waterDuration,
                landStartTime, landDuration);

        return (int) Math.min(landToWater, waterToLand);
    }
}