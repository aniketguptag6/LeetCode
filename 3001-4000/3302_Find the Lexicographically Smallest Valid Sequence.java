class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        // dp[i] = maximum number of characters from the END of word2
        // that can be matched using word1[i...n-1].
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && a[i] == b[j]) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Greedily choose the smallest possible index.
        while (i < n && j < m) {

            if (a[i] == b[j]) {
                // Exact match -> take it immediately.
                ans[j] = i;
                j++;
            } else {
                // Use our one allowed mismatch here IF
                // the rest of word2 can be matched exactly.
                if (dp[i + 1] >= m - 1 - j) {
                    ans[j] = i;
                    j++;
                    i++;

                    // Mismatch has now been used.
                    break;
                }
            }

            i++;
        }

        // IMPORTANT:
        // j < m is NOT automatically failure.
        // We may have used the mismatch and still need
        // to find the remaining exact matches.
        if (j < m && i == n) {
            return new int[0];
        }

        // Mismatch has been used, so all remaining characters
        // must match exactly.
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                ans[j] = i;
                j++;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}
