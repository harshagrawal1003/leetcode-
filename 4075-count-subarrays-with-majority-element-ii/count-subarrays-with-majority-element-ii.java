class Solution {
    static class Fenwick {
        int[] bit;
        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 1;
        Fenwick ft = new Fenwick(2 * n + 5);

        long ans = 0;
        int prefix = 0;

        ft.add(offset + 1, 1);

        for (int x : nums) {
            prefix += (x == target) ? 1 : -1;

            int idx = prefix + offset + 1;
            ans += ft.sum(idx - 1);

            ft.add(idx, 1);
        }

        return ans;
    }
}