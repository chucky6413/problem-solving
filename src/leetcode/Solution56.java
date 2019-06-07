package leetcode;

import java.util.Collections;
import java.util.List;

public class Solution56 {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (itv1, itv2) -> itv1.start - itv2.start);
        int cur = 0;
        while (cur < intervals.size() - 1) {
            if (intervals.get(cur).end >= intervals.get(cur + 1).start) {
                intervals.get(cur).end = Math.max(intervals.get(cur).end, intervals.get(cur + 1).end);
                intervals.remove(cur + 1);
            } else {
                cur++;
            }
        }
        return intervals;
    }
}