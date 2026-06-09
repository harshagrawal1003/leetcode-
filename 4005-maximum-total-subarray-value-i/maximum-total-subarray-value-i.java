class Solution {
    public long maxTotalValue(int[] nums, int k) {
          long mx = nums[0];
        long mn = nums[0];

        for (int x : nums) {
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }

        return (mx - mn) * k;
    }
}