class Solution {
    static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m + 1];
        long[] down = new long[m + 1];
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }
        for (int len = 3; len <= n; len++) {
            long[] prefDown = new long[m + 1];
            long[] prefUp = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
            }
            long totalUp = prefUp[m];
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];
            for (int x = 1; x <= m; x++) {
                newUp[x] = prefDown[x - 1];
                long greaterUp = (totalUp - prefUp[x] + MOD) % MOD;
                newDown[x] = greaterUp;
            }
            up = newUp;
            down = newDown;
        }
        long ans = 0;
        for (int v = 1; v <= m; v++) 
            ans = (ans + up[v] + down[v]) % MOD;
        
        return (int) ans;
    }
}