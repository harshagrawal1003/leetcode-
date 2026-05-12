class Solution {
    public int minimumEffort(int[][] tasks) {
         Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        int ans = 0, energy = 0;
        for(int[] it : tasks)
        {
            int actual = it[0];
            int minimum = it[1];
            if(energy < minimum)
            {
                ans += (minimum - energy);
                energy = minimum;
            }
            energy -= actual;
        }
        return ans;
    }
}