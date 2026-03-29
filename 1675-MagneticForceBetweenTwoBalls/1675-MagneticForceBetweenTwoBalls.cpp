// Last updated: 3/29/2026, 9:53:58 PM
class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
int start=1,end,mid,ans,n=position.size();
//sort
sort(position.begin(),position.end());
end=position[n-1]-position[0];
while(start<=end)
{
    mid=start+(end-start)/2;
    int count=1,pos=position[0];
    for(int i=1;i<n;i++)
    {
        if(position[i]>=pos+mid)
        {
            count++;
            pos=position[i];
        }
    }
    if(count<m)
    end=mid-1;
    else
    {
        ans=mid;
        start=mid+1;
            }
}
return ans;
    }
};