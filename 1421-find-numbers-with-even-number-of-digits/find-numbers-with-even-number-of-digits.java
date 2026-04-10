class Solution {
    public int findNumbers(int[] arr) {
        int a=0;
        for( int i=0;i<arr.length;i++)
        {
           int even=(int)(Math.log10(arr[i]))+1;
             if(even%2==0)
             a++;
        }
        return a;
    }

}