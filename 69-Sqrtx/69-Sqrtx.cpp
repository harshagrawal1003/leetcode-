// Last updated: 3/29/2026, 9:54:16 PM
class Solution {
public:
    int mySqrt(int x) {
         int start = 0, end = x;
    int ans = 0;

    while (start <= end) {
        int mid = start + (end - start) / 2;
  // Avoid division by zero
        if (mid == 0) {
            start = mid + 1;
            continue;
        }

        if (mid== x/mid)
            return mid; // perfect square
        else if (mid < x/mid) {
            ans = mid; // store last valid mid
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return ans;
    }
};