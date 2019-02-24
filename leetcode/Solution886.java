import java.util.ArrayList;
import java.util.List;

public class Solution886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            adjList.get(d[0] - 1).add(d[1] - 1);
            adjList.get(d[1] - 1).add(d[0] - 1);
        }

        boolean[] visit = new boolean[N];
        boolean[] color = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visit[i] && !isBipartiteDfs(adjList, i, visit, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteDfs(List<List<Integer>> adjList, int cur, boolean[] visit, boolean[] color) {
        visit[cur] = true;

        for (int adj : adjList.get(cur)) {
            if (!visit[adj]) {
                color[adj] = !color[cur];
                if (!isBipartiteDfs(adjList, adj, visit, color)) {
                    return false;
                }
            } else if (color[adj] == color[cur]) {
                return false;
            }
        }
        return true;
    }
}