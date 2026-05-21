class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       HashSet<Integer> prefixes = new HashSet<>();
        for (int num : arr1) {
            int x = num;
            while (x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }
        int ans = 0;
        for (int num : arr2) {
            int x = num;
            while (x > 0) {
                if (prefixes.contains(x)) {
                    ans = Math.max(ans, String.valueOf(x).length());
                }
                x /= 10;
            }
        }
        return ans;  
    }
}