// Last updated: 3/29/2026, 9:54:07 PM
class Solution {
public:
    int addDigits(int num) {
        while(num > 9) { // Repeat until num is a single digit
            int ans = 0;
            int rem =0;
            while(num != 0) {
                rem=num%10;
                ans += rem; // Add the last digit
                num /= 10;       // Remove the last digit
            }
            num = ans; // Update num to the sum of its digits
        }
        return num;
    }
};
