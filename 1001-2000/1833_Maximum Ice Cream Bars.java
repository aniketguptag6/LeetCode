class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int maxCost = 100000;
        int[] freq = new int[maxCost + 1];

        // count frequency
        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int price = 1; price <= maxCost; price++) {
            while (freq[price] > 0 && coins >= price) {
                coins -= price;
                freq[price]--;
                count++;
            }
        }

        return count;

    }
}
