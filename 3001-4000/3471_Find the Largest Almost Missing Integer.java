class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1
        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : nums) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int ans = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }

        // Case 2
        if (k == n) {
            int ans = nums[0];
            for (int x : nums) {
                ans = Math.max(ans, x);
            }
            return ans;
        }

        // Case 3
        int ans = -1;

        boolean firstUnique = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[0]) {
                firstUnique = false;
                break;
            }
        }
        if (firstUnique) {
            ans = nums[0];
        }

        boolean lastUnique = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[n - 1]) {
                lastUnique = false;
                break;
            }
        }
        if (lastUnique) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}
