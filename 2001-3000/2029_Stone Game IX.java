class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        // Count stones based on remainder when divided by 3
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If number of 0-mod-3 stones is even,
        // Alice wins iff both 1-mod-3 and 2-mod-3 stones exist.
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If number of 0-mod-3 stones is odd,
        // Alice wins only if the difference is greater than 2.
        return Math.abs(count[1] - count[2]) > 2;
    }
}
