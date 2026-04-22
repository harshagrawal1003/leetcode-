class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
         List<String> result = new ArrayList<>();
        
        for (String query : queries) {
            for (String word : dictionary) {
                if (diffCount(query, word) <= 2) {
                    result.add(query);
                    break; // no need to check further dictionary words
                }
            }
        }
        
        return result;
    }
    private static int diffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) return count; // early exit
            }
        }
        return count;
    }
}