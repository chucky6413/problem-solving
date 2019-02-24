import java.util.ArrayList;
import java.util.List;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int adj : graph[i]) {
                adjList.get(i).add(adj);
                adjList.get(adj).add(i);
            }
        }

        boolean[] visited = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && !isBipartiteDfs(adjList, i, visited, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteDfs(List<List<Integer>> adjList, int cur, boolean[] visited, boolean[] color) {
        visited[cur] = true;

        for (int adj : adjList.get(cur)) {
            if (!visited[adj]) {
                color[adj] = !color[cur];
                if (!isBipartiteDfs(adjList, adj, visited, color)) {
                    return false;
                }
            } else if (color[adj] == color[cur]) {
                return false;
            }
        }
        return true;
    }
}