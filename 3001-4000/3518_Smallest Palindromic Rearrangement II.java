class Solution {

    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        int halfLen = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder left = new StringBuilder();

        while (halfLen > 0) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, halfLen - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    halfLen--;
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long res = 1;
        int remain = total;

        for (int x : cnt) {
            if (x == 0)
                continue;
            res = multiplyChoose(res, remain, x);
            if (res >= LIMIT)
                return LIMIT;
            remain -= x;
        }

        return res;
    }

    private long multiplyChoose(long cur, int n, int r) {
        r = Math.min(r, n - r);

        for (int i = 1; i <= r; i++) {

            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(cur, den);
            cur /= g;
            den /= g;

            if (cur > LIMIT / num)
                return LIMIT;

            cur *= num;
            cur /= den;

            if (cur >= LIMIT)
                return LIMIT;
        }

        return cur;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
