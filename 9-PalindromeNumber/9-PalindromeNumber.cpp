// Last updated: 4/6/2026, 3:20:03 PM
class Solution {
public:
    bool isPalindrome(int x) {
        long r=0,s=x,rem;
        while(s!=0)
        {
           rem=s%10;
           r=r*10+rem;
           s/=10;
        }
        if(r==x&&x>=0)
        {
            return true;
        }
        return false;
    }
};