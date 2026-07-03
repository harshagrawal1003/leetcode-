class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
         int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        int maxCost = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            graph[u].add(new int[]{v, cost});
            indegree[v]++;
            maxCost = Math.max(maxCost, cost);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] topo = new int[n];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[index++] = node;

            for (int[] edge : graph[node]) {
                int next = edge[0];

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        int low = 0;
        int high = maxCost;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, graph, topo, online, k)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int score,
                               List<int[]>[] graph,
                               int[] topo,
                               boolean[] online,
                               long k) {

        int n = online.length;
        long INF = Long.MAX_VALUE / 2;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int node : topo) {
            if (!online[node] || dist[node] == INF) {
                continue;
            }

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int cost = edge[1];

                if (!online[next] || cost < score) {
                    continue;
                }

                long newCost = dist[node] + cost;

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}