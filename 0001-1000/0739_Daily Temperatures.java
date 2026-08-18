class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        // Stores indices of days with decreasing temperatures
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer than the temperature
            // at the index on top of the stack
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }

        return answer;
    }
}
