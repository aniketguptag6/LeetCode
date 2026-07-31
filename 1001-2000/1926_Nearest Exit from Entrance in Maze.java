class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+'; // mark visited

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (maze[nr][nc] == '+')
                    continue;

                // Check if it's an exit
                if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1)
                    return dist + 1;

                maze[nr][nc] = '+';
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }

        return -1;
    }
}
