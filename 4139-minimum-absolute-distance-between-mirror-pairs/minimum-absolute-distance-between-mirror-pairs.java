class Solution {
    public int minMirrorPairDistance(int[] nums) {
          Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            ans=Math.min(ans,i-map.get(nums[i]));
        
        map.put(reverse(nums[i]),i);
        }
    
 if(ans==Integer.MAX_VALUE)
 return -1;
 else return ans;
    }
    static int reverse(int x)
    {
        int y=x,rev=0;
        while(y>0)
        {
            rev=rev*10+y%10;
            y/=10;
        }
        return rev;
    }
}