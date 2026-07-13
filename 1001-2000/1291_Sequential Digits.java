class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int start = 1; start <= 9; start++) {
            int num = 0;

            for (int digit = start; digit <= 9; digit++) {
                num = num * 10 + digit;

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
