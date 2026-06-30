class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, n = s.length();
        int[] count = new int[3]; // count[0]=a, count[1]=b, count[2]=c
        int ans = 0;

        while (right < n) {
            count[s.charAt(right) - 'a']++;

            // Shrink window from left while all three chars are present
            // Every valid window can extend to the right up to n-1, so add (n - right)
            while (isValid(count)) {
                ans += (n - right);
                count[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return ans;
    }

    boolean isValid(int[] count) {
        return count[0] > 0 && count[1] > 0 && count[2] > 0;
    }
}
