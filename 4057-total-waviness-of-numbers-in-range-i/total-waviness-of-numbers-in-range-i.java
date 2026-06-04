class Solution {

    private int waviness(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        if (n < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);

            if ((curr > prev && curr > next) ||
                (curr < prev && curr < next)) {
                count++;
            }
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }
}