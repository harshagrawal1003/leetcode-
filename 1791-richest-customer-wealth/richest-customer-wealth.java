class Solution {
    public int maximumWealth(int[][] arr) {
        int su1=0;
        for(int i=0;i<arr.length;i++)
        
        { int sum=0;
         for(int j=0;j<arr[i].length;j++)
         {
            sum+=arr[i][j];
         }
         if(sum>su1)
         su1=sum;
        }
        return su1;
    }
}