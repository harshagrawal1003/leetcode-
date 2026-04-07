// Last updated: 4/7/2026, 8:32:37 PM
class Solution {
public:
    int smallestEqual(vector<int>& arr) {
    
        for(int i=0;i<arr.size();i++)
        {
 if(i % 10 == arr[i]) 
            return i;
            
        }
        return -1;
        
    }
};