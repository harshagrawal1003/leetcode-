class Solution {
    public int[] findErrorNums(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correct = arr[i] - 1;

            if (arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        for(int j=0;j<arr.length;j++)
        {
            if(j+1!=arr[j])
            return new int[]{arr[j],j+1};
        } 
         return new int[]{-1,-1};
    }
          static void swap(int[]arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}