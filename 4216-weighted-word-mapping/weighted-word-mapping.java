class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
           StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            int rem = sum % 26;
            char mapped = (char) ('z' - rem);
            ans.append(mapped);
        }

        return ans.toString();
    }
}