class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[] edge = new int[2];
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0], edges[i][1])) {
                edge[0] = edges[i][0];
                edge[1] = edges[i][1];
            }
        }
        return edge;
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return false;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // write back: x now points directly to root
        }
        return parent[x];
    }
}
