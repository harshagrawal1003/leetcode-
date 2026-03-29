// Last updated: 3/29/2026, 9:54:01 PM
class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int start=0,end=arr.size()-1,mid;
        while(start<=end)
        {
            mid=end+(start-end)/2;
           if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
           return mid; 
           //right size jane ke liye
           else if(arr[mid]>arr[mid-1])
           start=mid+1;
           else
           end=mid-1;


        }
        return -1;
    }
};