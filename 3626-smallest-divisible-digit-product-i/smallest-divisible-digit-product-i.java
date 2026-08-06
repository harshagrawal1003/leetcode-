class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int product = 1;
            int num = n;

            while (num > 0) {
                product *= (num % 10);
                num /= 10;
            }

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}