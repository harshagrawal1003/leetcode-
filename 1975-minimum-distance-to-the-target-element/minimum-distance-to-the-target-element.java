class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans=-1,ans1=-1;
        for(int i=start;i<nums.length;i++)
        {
            if(nums[i]==target){
          ans=Math.abs(i-start);
         break;
            }
        }
          for(int i=start-1;i>=0;i--)
        {
            if(nums[i]==target)
           {
              ans1=Math.abs(i-start);
         break;
           }
        }
        if(ans == -1) return ans1;
        if(ans1 == -1) return ans;

        return Math.min(ans, ans1);
        
    }
}