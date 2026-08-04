class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;

        // Fill left heap
        while (left <= right && leftHeap.size() < candidates) {
            leftHeap.offer(costs[left++]);
        }

        // Fill right heap
        while (left <= right && rightHeap.size() < candidates) {
            rightHeap.offer(costs[right--]);
        }

        long total = 0;

        while (k-- > 0) {
            if (rightHeap.isEmpty() ||
                (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {

                total += leftHeap.poll();

                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                total += rightHeap.poll();

                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return total;
    }
}
