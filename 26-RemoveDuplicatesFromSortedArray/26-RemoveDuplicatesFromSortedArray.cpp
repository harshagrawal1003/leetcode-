// Last updated: 3/29/2026, 9:54:22 PM
class Solution {
public:
    int removeDuplicates(vector<int>& arr) {
        int i=0;
        for(int j=1;j<arr.size();j++)
        {
            if(arr[j]!=arr[i])
            {
         
                arr[i+1]=arr[j];
                       i++;
            }
        }
        return i+1;
    }
};