/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
      int peak = findPeak(mountainArr);

        int firstTry = binarySearch(mountainArr, target, 0, peak, true);
        if (firstTry != -1) return firstTry;

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
              }
    static int findPeak(MountainArray arr)
    {
          int start = 0, end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            int midVal = arr.get(mid);
            int nextVal = arr.get(mid + 1);

            if (midVal > nextVal) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;}
   
    
     int binarySearch(MountainArray arr, int target, int start, int end, boolean asc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (asc) {
                if (val > target) end = mid - 1;
                else start = mid + 1;
            } else {
                if (val > target) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
    
}