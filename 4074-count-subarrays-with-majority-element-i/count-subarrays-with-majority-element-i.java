class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
int sum=0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target)
                    sum++;
                else
                    sum--;

                if (sum > 0)
                    ans++;
            }
        }

        return ans;
    }
}