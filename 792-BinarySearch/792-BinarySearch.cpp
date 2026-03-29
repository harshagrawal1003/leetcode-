// Last updated: 3/29/2026, 9:54:02 PM
class Solution {
public:
    int search(vector<int>& arr, int target) {
        int n=arr.size();
        int start=0,end=n-1,mid;
    
        while(start<=end)
        {
            mid=(start+end)/2;
            if(arr[mid]==target)
            return mid;
            else if(arr[mid]<target)
            start=mid+1;
            else
            end=mid-1 ;       }
    return -1;
    }
  
};