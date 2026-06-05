class Solution {

    static class Pair {
        long cnt;
        long wav;

        Pair(long c, long w) {
            cnt = c;
            wav = w;
        }
    }

    String s;
    Pair[][][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        s = Long.toString(n);

        memo = new Pair[s.length()][2][2][3][11][11];

        return dfs(0, 1, 0, 0, 10, 10).wav;
    }

    private Pair dfs(int pos, int tight, int started,
                     int len, int prev2, int prev1) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][tight][started][len][prev2][prev1] != null) {
            return memo[pos][tight][started][len][prev2][prev1];
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalWav = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair child = dfs(pos + 1, ntight, 0, 0, 10, 10);

                totalCnt += child.cnt;
                totalWav += child.wav;

            } else {

                int nstarted = 1;

                if (len == 0) {

                    Pair child =
                        dfs(pos + 1, ntight, nstarted, 1, 10, d);

                    totalCnt += child.cnt;
                    totalWav += child.wav;

                } else if (len == 1) {

                    Pair child =
                        dfs(pos + 1, ntight, nstarted, 2, prev1, d);

                    totalCnt += child.cnt;
                    totalWav += child.wav;

                } else {

                    int add =
                        ((prev1 > prev2 && prev1 > d) ||
                         (prev1 < prev2 && prev1 < d)) ? 1 : 0;

                    Pair child =
                        dfs(pos + 1, ntight, nstarted, 2, prev1, d);

                    totalCnt += child.cnt;
                    totalWav += child.wav + add * child.cnt;
                }
            }
        }

        return memo[pos][tight][started][len][prev2][prev1] =
            new Pair(totalCnt, totalWav);
    }
}