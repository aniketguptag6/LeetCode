import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap
            if (intervals[i][0] < prevEnd) {
                removed++;
            } else {
                // No overlap, keep this interval
                prevEnd = intervals[i][1];
            }
        }

        return removed;
    }
}
