package leetcode;

import java.util.List;
import java.util.Stack;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        int c = 1;
        while (!stack.isEmpty()) {
            int roomNumber = stack.pop();
            for (int key : rooms.get(roomNumber)) {
                if (!visited[key]) {
                    c++;
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        return c == rooms.size();
    }
}
