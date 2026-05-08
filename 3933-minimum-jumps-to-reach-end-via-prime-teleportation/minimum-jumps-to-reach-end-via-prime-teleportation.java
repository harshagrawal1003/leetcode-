class Solution {
    private boolean Prime(int x) {
        if (x < 2)
         return false;
        if (x == 2)
         return true;
        if (x % 2 == 0)
         return false;
        for (int i = 3; i * i <= x; i += 2) 
            if (x % i == 0) return false;
        return true;
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> divisibleMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            for (int d = 1; d * d <= val; d++) {
                if (val % d == 0) {
                    if (Prime(d)) {
                        divisibleMap
                            .computeIfAbsent(d, k -> new ArrayList<>())
                            .add(i);
                    }
                    int other = val / d;
                    if (other != d && Prime(other)) {
                        divisibleMap
                            .computeIfAbsent(other, k -> new ArrayList<>())
                            .add(i);
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) return steps;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                int val = nums[i];

                if (Prime(val) && !usedPrime.contains(val)) {

                    List<Integer> nextIndices =
                        divisibleMap.getOrDefault(val, new ArrayList<>());

                    for (int idx : nextIndices) {
                        if (!visited[idx]) {
                            visited[idx] = true;
                            q.offer(idx);
                        }
                    }

                    usedPrime.add(val);
                }
            }

            steps++;
        }

        return -1;
    }
}