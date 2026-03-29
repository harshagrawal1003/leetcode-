// Last updated: 3/29/2026, 9:53:54 PM
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int start=0,end=0,mid,ans,n=piles.size();
        long long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=piles[i];
            end=max(end,piles[i]);
        }
        start=sum/h;
        if(start==0)
        start=1;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            //mid banana consume
            int totaltime=0;
            for(int i=0;i<n;i++)
            {
                totaltime+=piles[i]/mid;
                if(piles[i]%mid)
                totaltime++;

            }
            if(totaltime>h)
            {
                start=mid+1;
            }
            else
            {
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
};