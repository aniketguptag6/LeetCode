class Solution {
    public int uniqueXorTriplets(int[] nums) {

        // Find the maximum value in the array
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        // Find the smallest power of 2 greater than maxValue.
        // All XOR results will lie in [0, xorLimit - 1].
        int xorLimit = 1;
        while (xorLimit <= maxValue) {
            xorLimit <<= 1;
        }

        // oneNumber[x] = Can XOR value x be formed using exactly 1 number?
        boolean[] oneNumber = new boolean[xorLimit];

        // twoNumbers[x] = Can XOR value x be formed using exactly 2 numbers?
        boolean[] twoNumbers = new boolean[xorLimit];

        // threeNumbers[x] = Can XOR value x be formed using exactly 3 numbers?
        boolean[] threeNumbers = new boolean[xorLimit];

        // -------------------------
        // Build XORs using 1 number
        // -------------------------
        for (int num : nums) {
            oneNumber[num] = true;
        }

        // -------------------------
        // Build XORs using 2 numbers
        // -------------------------
        for (int num : nums) {
            for (int xorValue = 0; xorValue < xorLimit; xorValue++) {
                if (oneNumber[xorValue]) {
                    twoNumbers[xorValue ^ num] = true;
                }
            }
        }

        // -------------------------
        // Build XORs using 3 numbers
        // -------------------------
        for (int num : nums) {
            for (int xorValue = 0; xorValue < xorLimit; xorValue++) {
                if (twoNumbers[xorValue]) {
                    threeNumbers[xorValue ^ num] = true;
                }
            }
        }

        // Count distinct XOR values
        int answer = 0;
        for (boolean possible : threeNumbers) {
            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}
