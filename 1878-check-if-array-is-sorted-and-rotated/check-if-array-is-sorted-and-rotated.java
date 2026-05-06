class Solution {
    public boolean check(int[] arr) {
        int a=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<arr[i-1])
            a++;
        }
         if (arr[0] < arr[arr.length - 1]) {
            a++;
        }
        if(a<=1)
        return true;
        else
        return false;
    }
}