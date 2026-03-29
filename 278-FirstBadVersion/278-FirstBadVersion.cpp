// Last updated: 3/29/2026, 9:54:06 PM
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int start=1,end=n;
        int bad=0;
        if(n==0||n==1)
        return n;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)==false)
            {
                bad=mid;
                start=mid+1;
            }
            else 
            end=mid-1;
        }
        return bad+1;
    }
};