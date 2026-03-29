// Last updated: 3/29/2026, 9:54:08 PM
class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n<1)
        return 0;
        while(n!=1)
        {if(n%2==1)
        return 0;
        n=n/2;    }
    return 1;}
};