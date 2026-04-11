class Solution {
    public char nextGreatestLetter(char[] app, char target) {
          int start=0;
        int end=app.length-1;
      
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(app[mid]>target)
            {
                end=mid-1;
            }
            else
                start=mid+1;
        }
      
        return app[start%app.length];
    }
}