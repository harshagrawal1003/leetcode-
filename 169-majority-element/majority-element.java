class Solution {
    public int majorityElement(int[] arr) {
         int cnt=0,el=0;
        for(int i:arr){
            if (cnt==0){
                cnt++;
                el=i;
            }
            else if(i==el)
                cnt++;
            else
                cnt--;

        }
       return el;
    }
}