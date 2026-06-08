class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
         int[] ans = new int[nums.length];
        int k = 0;

        for (int x : nums)
            if (x < pivot)
                ans[k++] = x;

        for (int x : nums)
            if (x == pivot)
                ans[k++] = x;

        for (int x : nums)
            if (x > pivot)
                ans[k++] = x;

        return ans;
    }
}