class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
          int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        int maxDist = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDist;
    }
}