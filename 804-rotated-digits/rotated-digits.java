class Solution {
    public int rotatedDigits(int n) {
          int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count; 
    }
      static boolean isGood(int num) {
        boolean diff = false;
        while (num > 0) {
            int d = num % 10;
            if (d == 3 || d == 4 || d == 7) return false; 
            if (d == 2 || d == 5 || d == 6 || d == 9) diff = true;
            num /= 10;
        }
        return diff;
    }
}