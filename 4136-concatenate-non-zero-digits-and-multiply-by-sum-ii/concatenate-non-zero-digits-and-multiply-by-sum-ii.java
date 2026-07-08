class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long mod = 1000000007L;
        int n = s.length();

        int[] count = new int[n + 1];
        long[] sum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            count[i + 1] = count[i];
            sum[i + 1] = sum[i];

            if (digit != 0) {
                count[i + 1]++;
                sum[i + 1] += digit;
            }
        }

        int total = count[n];

        long[] prefix = new long[total + 1];
        long[] power = new long[total + 1];

        power[0] = 1;

        for (int i = 1; i <= total; i++) {
            power[i] = (power[i - 1] * 10) % mod;
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                prefix[index + 1] =
                        (prefix[index] * 10 + digit) % mod;
                index++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = count[l];
            int right = count[r + 1];

            int len = right - left;

            long x = (prefix[right]
                    - (prefix[left] * power[len]) % mod
                    + mod) % mod;

            long digitSum = sum[r + 1] - sum[l];

            ans[i] = (int) ((x * digitSum) % mod);
        }

        return ans;
    }
}