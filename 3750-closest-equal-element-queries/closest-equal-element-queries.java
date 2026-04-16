class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
     int n = nums.length;

        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

      
        for (int q : queries) {
            int val = nums[q];
            ArrayList<Integer> list = map.get(val);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // find position using binary search
            int pos = Collections.binarySearch(list, q);

            int left = list.get((pos - 1 + list.size()) % list.size());
            int right = list.get((pos + 1) % list.size());

            int d1 = Math.abs(q - left);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(q - right);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        

        return ans;
    }
}