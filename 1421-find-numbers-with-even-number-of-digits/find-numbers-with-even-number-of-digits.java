class Solution {
    public int findNumbers(int[] nums) {
        int a=0;
        for( int i :nums)
        {
           int even=(int)(Math.log10(i))+1;
             if(even%2==0)
             a++;
        }
        return a;
    }

}