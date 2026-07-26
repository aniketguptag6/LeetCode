class Solution {
    public int maximumProduct(int[] nums) {
         int top1 = Integer.MIN_VALUE; // largest
        int top2 = Integer.MIN_VALUE; // second largest
        int top3 = Integer.MIN_VALUE; // third largest

        // 2 smallest values
        int bot1 = Integer.MAX_VALUE; // smallest
        int bot2 = Integer.MAX_VALUE; // second smallest

         for (int num : nums) {

            // ── Update top 3 ──────────────────────────
            if (num >= top1) {
                // New largest — shift everyone down
                top3 = top2;
                top2 = top1;
                top1 = num;
            } else if (num >= top2) {
                // Between top1 and top2
                top3 = top2;
                top2 = num;
            } else if (num > top3) {
                // Between top2 and top3
                top3 = num;
            }
            // ── Update bottom 2 ───────────────────────
            if (num <= bot1) {
                // New smallest — shift down
                bot2 = bot1;
                bot1 = num;
            } else if (num < bot2) {
                // Between bot1 and bot2
                bot2 = num;
            }
        }
         // Option 1: top 3 largest
        int opt1 = top1 * top2 * top3;

        // Option 2: 2 smallest × largest
        int opt2 = bot1 * bot2 * top1;

        return Math.max(opt1, opt2); 

    }
}
