// Last updated: 3/29/2026, 9:54:11 PM
class Solution {
public:
    vector<int> twoSum(vector<int>& n, int t) {
        int start=0,end=n.size()-1;
        vector<int>ans;
        while(start<end)
        {
            if(n[start]+n[end]==t)
            {
                ans.push_back(start+1);
                 ans.push_back(end+1);
                 return ans;

            }
            else if(n[start]+n[end]<t)
            start++;
            else
            end--;
        }
        return ans;
    }
};