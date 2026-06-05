class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
          int maxi=0;
        int count=0;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==1)
                count++;
            else {
                maxi=Math.max(count,maxi);
                count=0;
            }
        }
        return Math.max(count,maxi);
    }
}