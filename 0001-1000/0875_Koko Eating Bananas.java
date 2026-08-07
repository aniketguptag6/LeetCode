class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find maximum pile size
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;
                right = mid - 1; // Try slower speed
            } else {
                left = mid + 1;  // Need faster speed
            }
        }

        return ans;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // ceil(pile/speed)

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
