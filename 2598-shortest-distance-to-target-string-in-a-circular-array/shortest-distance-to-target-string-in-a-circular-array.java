class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                int clockwise = (i - startIndex + n) % n;
                int counterclockwise = (startIndex - i + n) % n;
                minDistance = Math.min(minDistance, Math.min(clockwise, counterclockwise));
            }
        }

        return found ? minDistance : -1;
    }
}