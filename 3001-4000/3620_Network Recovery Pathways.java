class Solution {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxEdge = 0;
        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        int[] indeg = indegree.clone();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (Edge e : graph[u]) {
                if (--indeg[e.to] == 0) {
                    q.offer(e.to);
                }
            }
        }

        int lo = 0, hi = maxEdge;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit, List<Edge>[] graph, int[] topo,
                          boolean[] online, long k) {

        int n = online.length;
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to;

                if (e.cost < limit) continue;

                if (v != n - 1 && !online[v]) continue;

                if (dist[v] > dist[u] + e.cost) {
                    dist[v] = dist[u] + e.cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
