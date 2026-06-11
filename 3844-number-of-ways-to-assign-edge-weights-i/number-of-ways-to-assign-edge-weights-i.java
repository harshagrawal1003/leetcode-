class Solution {
    private static final long MOD = 1_000_000_007L;

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(new int[]{1, 0});
        vis[1] = true;

        int maxDepth = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int depth = curr[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int next : adj[node]) {
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }

        return (int) modPow(2, maxDepth - 1);
    }
}