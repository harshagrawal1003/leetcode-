// Last updated: 3/29/2026, 9:53:55 PM
class Solution {
public:
    int findKthPositive(vector<int>& nums, int k) {
         int start=0,end=nums.size()-1,mid,index=nums.size();
    
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]-mid-1>=k)
            {
                index=mid;
               end=mid-1;
               
            }
            else 
            start=mid+1;
              }

        return index+k;
    }
};