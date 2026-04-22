class Solution {
    public int countPrimes(int n) {
                boolean[] b=new boolean[n+1];
       return  sieve(n,b);

    }
     static int sieve(int n ,boolean[] prime)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(!prime[i])
            {
                for(int j=i*2;j<=n;j+=i)
                {
                    prime[j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++)
        {
            if(!prime[i])
                count++;
        }
        return count;
}
}