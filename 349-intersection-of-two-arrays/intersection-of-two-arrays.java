import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        ArrayList<Integer> uni = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {

                if (uni.isEmpty() || uni.get(uni.size()-1) != nums1[i]) {
                    uni.add(nums1[i]);
                }

                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int[] a = new int[uni.size()];

        for (int k = 0; k < uni.size(); k++) {
            a[k] = uni.get(k);
        }

        return a;
    }
}