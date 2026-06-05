class Solution {
    public int singleNumber(int[] arr) {
         int no=0;
        for (int i = 0; i < arr.length; i++) {
            no^=arr[i];
        }
        return no;
    }
}