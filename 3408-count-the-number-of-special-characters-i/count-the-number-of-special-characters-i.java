class Solution {
    public int numberOfSpecialChars(String word) {
         int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            boolean lower = false;
            boolean upper = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch)
                    lower = true;

                if (word.charAt(i) == Character.toUpperCase(ch))
                    upper = true;
            }

            if (lower && upper)
                count++;
        }

        return count;
    }
}