class Solution {
     public int minJumps(int[] arr) {
     int n = arr.length;
        
        if(n == 1)
            return 0;
        
        // value -> all indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            
            map.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        q.offer(0);
        vis[0] = true;
        
        int steps = 0;
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(size-- > 0) {
                
                int i = q.poll();
                
                // reached end
                if(i == n - 1)
                    return steps;
                
                // left jump
                if(i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }
                
                // right jump
                if(i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }
                
                // same value jump
                if(map.containsKey(arr[i])) {
                    
                    for(int idx : map.get(arr[i])) {
                        
                        if(!vis[idx]) {
                            vis[idx] = true;
                            q.offer(idx);
                        }
                    }
                    
                    // remove so we don't process again
                    map.remove(arr[i]);
                }
            }
            
            steps++;
        }
        
        return -1;
}
}