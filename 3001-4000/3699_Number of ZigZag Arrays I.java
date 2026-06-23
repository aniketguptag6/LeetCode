class Solution {
     private static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
         int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // length = 1
        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }
        for (int len = 2; len <= n; len++) {

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] = (prefUp[i] + up[i]) % MOD;
                prefDown[i + 1] = (prefDown[i] + down[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int y = 0; y < m; y++) {

                // previous value < y
                newUp[y] = prefDown[y];

                // previous value > y
                newDown[y] =
                    (prefUp[m] - prefUp[y + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }
        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
