class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int i=0,j=arr.length-1;
        if(arr.length==1)
        return arr;
        else
        while(i<j){
            if(arr[i]%2==0)
            i++;
           else if(arr[j]%2!=0)
            j--;
            else {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;j--;
            }
        }
        return arr;
    }
}