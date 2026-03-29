// Last updated: 3/29/2026, 9:54:12 PM
class Solution {
public:
    int findPeakElement(vector<int>& arr) {
        int start=0,end=arr.size()-1,mid;
        while(start<end)
        {
            
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
            end= mid;
            else
            start=mid+1;
        
        }
        return start;

        
    }
};