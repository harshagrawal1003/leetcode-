class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;

            if (ql <= l && r <= qr)
                return tree[node];

            int mid = (l + r) >> 1;

            return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }

        int query(int l, int r) {
            if (l > r) return 0;
            return query(1, 0, n - 1, l, r);
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(MAX + 1);

        int prev = 0;
        for (int pos : obstacles) {
            if (pos == 0) continue;

            seg.update(pos, pos - prev);
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                int p = obstacles.floor(x);

                int best = seg.query(0, p);
                best = Math.max(best, x - p);

                ans.add(best >= sz);

            } else {

                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                if (right != null) {
                    seg.update(right, right - left);
                }

                seg.update(x, 0);
                obstacles.remove(x);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}