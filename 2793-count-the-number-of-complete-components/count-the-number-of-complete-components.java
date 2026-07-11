class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] counts = new int[2];
                dfs(i, adj, visited, counts);
                
                int nodeCount = counts[0];
                int edgeCount = counts[1] / 2;

                if (edgeCount == (nodeCount * (nodeCount - 1)) / 2) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, int[] counts) {
        visited[u] = true;
        counts[0]++;
        counts[1] += adj.get(u).size();

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, counts);
            }
        }
    }
}