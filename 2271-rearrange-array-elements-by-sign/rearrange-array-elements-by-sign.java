class Solution {
    public int[] rearrangeArray(int[] arr) {
          int[] ans=new int[arr.length];
        int pos=0,neg=1;
        for (int i:arr){
            if (i<0){
                ans[neg]=i;
                neg+=2;
            }
            else{
                ans[pos]=i;
                pos+=2;
            }
        }
        return ans;
    }
}