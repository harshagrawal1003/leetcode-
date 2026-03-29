// Last updated: 3/29/2026, 9:53:57 PM
class Solution {
public:
    int specialArray(vector<int>& nums) {
        int start=0,end=nums.size(),mid;
        sort(nums.begin(),nums.end());
        while(start<=end)
        {int count=0;
            mid=start+(end-start)/2;
            for(int i=0;i<nums.size();i++)
          { if(nums[i]>=mid)
            count++;
          }
          if(count==mid)
          return mid;
          else if(count>mid)
          start=mid+1;
          else
          end=mid-1;
        }
        return -1;
    }
};