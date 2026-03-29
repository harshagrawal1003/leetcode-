// Last updated: 3/29/2026, 9:54:10 PM
class Solution {
public:
    void rotate(vector<int>& arr, int k) {
        int n = arr.size();
        k = k % n;

        vector<int> temp(n);  

        
        for (int i = 0; i < k; i++) {
            temp[i] = arr[n - k + i];
        }

       
        for (int i = k; i < n; i++) {
            temp[i] = arr[i - k];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
};