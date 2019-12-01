package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution1263 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] box = new int[2];
        int[] dest = new int[2];
        int[] player = new int[2];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 'B') {
                    box[0] = r;
                    box[1] = c;
                } else if (grid[r][c] == 'S') {
                    player[0] = r;
                    player[1] = c;
                } else if (grid[r][c] == 'T') {
                    dest[0] = r;
                    dest[1] = c;
                }
            }
        }

        Set<String> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(box, player, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            String key = cur.box[0] + "/" + cur.box[1] + "/" + cur.player[0] + "/" + cur.player[1];
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);

            for (int[] dir : dirs) {
                int[] nxt_box = new int[]{cur.box[0], cur.box[1]};
                int[] nxt_player = new int[]{cur.player[0] + dir[0], cur.player[1] + dir[1]};
                int nxt_moveCnt = cur.moveCnt;

                if (isInvalid(nxt_player, grid)) {
                    continue;
                }

                if (nxt_player[0] == cur.box[0] && nxt_player[1] == cur.box[1]) {
                    nxt_box[0] += dir[0];
                    nxt_box[1] += dir[1];
                    nxt_moveCnt += 1;
                }

                if (isInvalid(nxt_box, grid)) {
                    continue;
                }

                if (isReach(nxt_box, grid)) {
                    return nxt_moveCnt;
                }

                pq.offer(new Node(nxt_box, nxt_player, nxt_moveCnt));
            }
        }

        return -1;
    }

    private boolean isReach(int[] pos, char[][] grid) {
        return grid[pos[0]][pos[1]] == 'T';
    }

    private boolean isInvalid(int[] pos, char[][] grid) {
        if (pos[0] < 0 || pos[0] >= grid.length || pos[1] < 0 || pos[1] >= grid[0].length) {
            return true;
        }
        return grid[pos[0]][pos[1]] == '#';
    }

    class Node implements Comparable<Node> {
        int[] box;
        int[] player;
        int moveCnt;

        public Node(int[] box, int[] player, int moveCnt) {
            this.box = box;
            this.player = player;
            this.moveCnt = moveCnt;
        }

        public int compareTo(Node n) {
            return moveCnt - n.moveCnt;
        }
    }
}