class Solution {
    public void rotate(int[] arr1, int p) {
          int n = arr1.length;

        // Handle case when p > n
        p = p % n;
reverse1(arr1,0,n-1);
reverse1(arr1,0,p-1);
reverse1(arr1,p,n-1);
    }
       public static void reverse1(int[] arr,int a,int b)
    {
        while(a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
}}