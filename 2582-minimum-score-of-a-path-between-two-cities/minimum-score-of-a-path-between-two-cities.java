class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int city = q.poll();

            for (int[] edge : graph[city]) {
                int nextCity = edge[0];
                int distance = edge[1];

                min = Math.min(min, distance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    q.offer(nextCity);
                }
            }
        }

        return min;
    }
}