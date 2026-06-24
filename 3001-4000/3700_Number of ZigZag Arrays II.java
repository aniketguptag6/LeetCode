class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        int size = 2 * m;

        long[][] trans = new long[size][size];

        /*
            States:

            0 ... m-1       => UP states
            m ... 2m-1      => DOWN states
        */

        // from UP(x) -> DOWN(y) where y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                trans[m + y][x] = 1;
            }
        }

        // from DOWN(x) -> UP(y) where y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                trans[y][m + x] = 1;
            }
        }

        // matrix power
        long[][] power = matrixPow(trans, n - 1);

        // initial vector
        long[] init = new long[size];

        // every value can start both up/down
        for (int i = 0; i < size; i++) {
            init[i] = 1;
        }

        // multiply
        long[] result = multiply(power, init);

        long ans = 0;

        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {

        int n = mat.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                res[i] =
                    (res[i] + mat[i][j] * vec[j]) % MOD;
            }
        }

        return res;
    }

    private long[][] matrixPow(long[][] mat, int power) {

        int n = mat.length;

        long[][] result = new long[n][n];

        // identity matrix
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {

            if ((power & 1) == 1) {
                result = multiplyMatrix(result, mat);
            }

            mat = multiplyMatrix(mat, mat);

            power >>= 1;
        }

        return result;
    }

    private long[][] multiplyMatrix(long[][] a, long[][] b) {

        int n = a.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {

                    res[i][j] =
                        (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}
