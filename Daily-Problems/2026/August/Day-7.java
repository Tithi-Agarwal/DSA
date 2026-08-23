//3302. Find the Lexicographically Smallest Valid Sequence

class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m];

        // Build suffix matching information
        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                suf[j] = -1;
            } else {
                suf[j] = i;
                i--;
            }
        }

        int[] ans = new int[m];

        i = 0;
        int j = 0;
        boolean changed = false;

        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                // Take it
                ans[j] = i;
                i++;
                j++;
            }

            // Mismatch: use our one change
            else if (!changed) {

                // Check whether the remaining part can be
                // matched after taking this index.
                if (j == m - 1 || 
                    (suf[j + 1] != -1 && suf[j + 1] > i)) {

                    ans[j] = i;

                    changed = true;
                    i++;
                    j++;
                } 
                else {
                    i++;
                }
            }

            else {
                i++;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}