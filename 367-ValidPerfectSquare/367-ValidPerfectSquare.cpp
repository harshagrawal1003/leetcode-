// Last updated: 3/29/2026, 9:54:03 PM
class Solution {
public:
    bool isPerfectSquare(int num) {
    long long start =0,end=num;
    long long mid;
    while(start<=end){
    mid=start+(end-start)/2;
    if(mid*mid==num)
    return 1;
    else if(mid*mid>=num)
    end=mid-1;
    else
    start=mid+1;
    }
    return 0;
    }
};