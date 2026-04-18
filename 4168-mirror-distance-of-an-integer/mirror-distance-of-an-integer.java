class Solution {
    public int mirrorDistance(int n) {
           int p=n,rev=0;
        while(p>0)
        {
            rev=rev*10+p%10;
            p/=10;
        }
   return Math.abs(rev-n);
    }
  
}