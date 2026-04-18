class Solution {
    public int compress(char[] sc) {
        if(sc.length==1)
        return 1;
     String ans=""+sc[0];
        int count=1;

        for(int i=1;i<sc.length;i++)
        {
            char curr=sc[i],prev=sc[i-1];
            if(curr==prev)
                count++;
            else{
             if(count>1)  ans+=count;
               ans+=curr;
               count=1;
            }
        }
        if(count > 1) ans += count;
        for(int i=0;i<ans.length();i++)
        {
            sc[i]=ans.charAt(i);
        }
     return ans.length();
    }
}