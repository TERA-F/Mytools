public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String src = equations[i][0], dst = equations[i][1];
            if (!graph.containsKey(src)) {
                graph.put(src, new HashMap<>());
            }
            if (!graph.containsKey(dst)) {
                graph.put(dst, new HashMap<>());
            }
            graph.get(src).put(src, 1.0);
            graph.get(dst).put(dst, 1.0);
            graph.get(src).put(dst, values[i]);
            graph.get(dst).put(src, 1 / values[i]);
        }
        for (String mid : graph.keySet()) {
            for (String src : graph.get(mid).keySet()) {
                for (String dst : graph.get(mid).keySet()) {
                    double val = graph.get(src).get(mid) * graph.get(mid).get(dst);
                    graph.get(src).put(dst, val);
                }
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (!graph.containsKey(queries[i][0])) {
                result[i] = -1;
            } else {
                result[i] = graph.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
            }
        }
        return result;
    }
}

