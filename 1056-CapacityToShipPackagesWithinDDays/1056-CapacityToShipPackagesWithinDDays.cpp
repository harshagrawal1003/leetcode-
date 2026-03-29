// Last updated: 3/29/2026, 9:53:59 PM
class Solution {
public:
    int shipWithinDays(vector<int>& arr, int k) {
    
      int start=0,end=0,mid,ans; for(int i=0;i<arr.size();i++) { start=max(start,arr[i]); end+=arr[i]; } while(start<=end) { mid=start+(end-start)/2; int pages=0,count=1; for(int i=0;i<arr.size();i++) { pages+=arr[i]; if(pages>mid){ count++; pages=arr[i]; } } if(count<=k) { ans=mid; end=mid-1; } else start =mid+1;} return ans; 
    }
};