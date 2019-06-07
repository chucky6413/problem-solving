package leetcode;

import java.util.*;

/**
 * ref : https://leetcode.com/problems/evaluate-division/discuss/88169/Java-AC-Solution-using-graph
 */

public class Solution399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> nodesMap = new HashMap<>();
        Map<String, ArrayList<Double>> valuesMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String A = equations[i][0];
            String B = equations[i][1];

            if (!nodesMap.containsKey(A)) {
                nodesMap.put(A, new ArrayList<String>());
                valuesMap.put(A, new ArrayList<Double>());
            }
            if (!nodesMap.containsKey(B)) {
                nodesMap.put(B, new ArrayList<String>());
                valuesMap.put(B, new ArrayList<Double>());
            }

            nodesMap.get(A).add(B);
            valuesMap.get(A).add(values[i]);

            nodesMap.get(B).add(A);
            valuesMap.get(B).add(1 / values[i]);
        }

        double[] rs = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String A = queries[i][0];
            String B = queries[i][1];

            double value = dfs(A, B, nodesMap, valuesMap, new HashSet<String>(), 1.0);
            if (value == 0.0) {
                value = -1.0;
            }
            rs[i] = value;
        }
        return rs;
    }

    private double dfs(String start, String end, Map<String, ArrayList<String>> nodesMap, Map<String, ArrayList<Double>> valuesMap, Set<String> history, double value) {
        if (history.contains(start)) {
            return 0.0;
        }

        if (!nodesMap.containsKey(start)) {
            return 0.0;
        }

        if (start.equals(end)) {
            return value;
        }

        history.add(start);
        List<String> nodes = nodesMap.get(start);
        List<Double> values = valuesMap.get(start);
        double rs = 0.0;
        for (int i = 0; i < nodes.size(); i++) {
            rs = dfs(nodes.get(i), end, nodesMap, valuesMap, history, value * values.get(i));
            if (rs != 0.0) {
                break;
            }
        }

        history.remove(start);
        return rs;
    }
}