package leetcode;

public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int total = 0;
        int dist = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start <= i && i < destination) {
                dist += distance[i];
            }
            total += distance[i];
        }
        return Math.min(dist, total - dist);
    }
}