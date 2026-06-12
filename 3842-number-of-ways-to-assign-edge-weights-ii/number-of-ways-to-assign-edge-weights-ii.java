import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    int LOG;
    int[][] up;
    int[] depth;
    long[] pow2;
    List<Integer>[] graph;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        pow2 = new long[n];
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[lca];

            ans[i] = dist == 0 ? 0 : (int) pow2[dist - 1];
        }

        return ans;
    }

    private void dfs(int root, int parent) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{root, parent});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0];
            int par = cur[1];

            up[node][0] = par;

            for (int nxt : graph[node]) {
                if (nxt == par) continue;

                depth[nxt] = depth[node] + 1;
                stack.push(new int[]{nxt, node});
            }
        }
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        int diff = depth[a] - depth[b];

        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                a = up[a][j];
            }
        }

        if (a == b) return a;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[a][j] != up[b][j]) {
                a = up[a][j];
                b = up[b][j];
            }
        }

        return up[a][0];
    }
}