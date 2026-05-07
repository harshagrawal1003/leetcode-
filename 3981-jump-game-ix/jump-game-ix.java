class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;
        int prefixMax = nums[0];
        int componentMax = nums[0];

        for (int i = 0; i < n - 1; i++) {

            prefixMax = Math.max(prefixMax, nums[i]);
            componentMax = Math.max(componentMax, nums[i]);
            if (prefixMax <= suffixMin[i + 1]) {

                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }

                start = i + 1;

                prefixMax = nums[start];
                componentMax = nums[start];
            }
        }
        componentMax = nums[start];

        for (int i = start; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = componentMax;
        }

        return ans;
    }
}