class Solution {
    public int splitArray(int[] nums, int m) {
         int start=0,end=0;
        for(int i=0;i<nums.length;i++)
        {
            start=Math.max(start,nums[i]); //contain max element of arr
            end+=nums[i];
        }
        while(start<end)
        {
            //try potential answer
            int mid=start+(end-start)/2;
            //cal how many pieces you can divide it in that sum
            int sum=0;
            int pieces=1;
            for(int num:nums)
            {
                if(sum+num>mid)
                {
                    pieces++;
                    sum=num;
                }
                else
                    sum+=num;
            }
            if(pieces>m)
                start=mid+1;
            else
                end=mid;
        }
return end;
    }
}