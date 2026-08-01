class Solution {
    int[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(nums, 0, n - 1) >= 0;
    }

    private int solve(int[] nums, int i, int j) {
        if (i == j)
            return nums[i];

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int takeLeft = nums[i] - solve(nums, i + 1, j);
        int takeRight = nums[j] - solve(nums, i, j - 1);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}