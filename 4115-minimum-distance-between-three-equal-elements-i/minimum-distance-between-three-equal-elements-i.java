class Solution {
    public int minimumDistance(int[] nums) {
             Map<Integer, int[]> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (!map.containsKey(val)) {
                map.put(val, new int[]{-1, -1});
            }

            int[] arr = map.get(val);

            if (arr[0] != -1 && arr[1] != -1) {
                int dist = 2 * (i - arr[0]);
                ans = Math.min(ans, dist);
            }

            arr[0] = arr[1];
            arr[1] = i;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}