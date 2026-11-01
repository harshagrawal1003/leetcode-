class Solution {
    public void nextPermutation(int[] arr) {
           int index=-1;
        for (int i = arr.length-2; i >=0 ; i--) {
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1)
        reverse(arr,0,arr.length-1);
  else{
        for (int i = arr.length-1; i >=index ; i--) {
            if(arr[i]>arr[index]){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                break;
            }
        }
        reverse(arr,index+1,arr.length-1);}
       
    }
      public static void reverse(int[]arr,int s,int end){
        while(s<end){
            int temp=arr[s];
            arr[s]=arr[end];
            arr[end]=temp;
            s++;
            end--;

        }
    
}
}