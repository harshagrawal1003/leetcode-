class Solution {
    public int maxDistance(int[] colors) {
          int n = colors.length;  
        int ma= 0;
        for (int j = n - 1; j >= 0; j--) {
            if (colors[j] != colors[0]) {
                ma = Math.max(ma, j);
                break;
            }}
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                ma = Math.max(ma, (n - 1 - i));
                break;
            }
        }
        
        return ma;
    }
}