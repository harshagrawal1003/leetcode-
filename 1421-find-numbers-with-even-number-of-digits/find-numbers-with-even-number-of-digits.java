class Solution {
    public int findNumbers(int[] nums) {
        int a=0;
        for( int i :nums)
        {
            if(even(i))
            a++;
        }
        return a;
    }
    public static boolean even(int c)
    {
        int count=0;
        while(c>0)
        {
            count++;
            c/=10;
        }
        if(count%2==0)
        return true;
        else
        return false;
    }
}