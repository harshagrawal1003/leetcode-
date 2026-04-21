class Solution {
    public int singleNumber(int[] nums) {
        int sum=0;
        for(int i:nums)
        {
            sum^=i;
        }
        return sum;
    }
}