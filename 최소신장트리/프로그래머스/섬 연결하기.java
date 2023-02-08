import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static class Bridge implements Comparable<Bridge> {
        int cost;
        int startIsland;
        int endIsland;

        public Bridge(int cost, int startIsland, int endIsland) {
            this.cost = cost;
            this.startIsland = startIsland;
            this.endIsland = endIsland;
        }

        @Override
        public int compareTo(Bridge o) {
            return this.cost - o.cost;
        }
    }

    private int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[100];
        for (int i = 0; i < 100; i++) {
            parent[i] = i;
        }

        List<Bridge> bridges = new ArrayList<>();

        for (int[] cost : costs) {
            bridges.add(new Bridge(cost[2], cost[0], cost[1]));
        }

        Collections.sort(bridges);

        int result = 0;
        for (Bridge bridge : bridges) {
            if (findParent(bridge.startIsland) != findParent(bridge.endIsland)) {
                union(bridge.startIsland, bridge.endIsland);
                result += bridge.cost;
            }
        }

        return result;
    }

    private void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

}
