class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> neib = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            neib.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            neib.putIfAbsent(equations.get(i).get(1), new HashMap<>()); //if a/b = 2
            neib.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]); //a = 2b
            neib.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]); //b = 1/2a
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), neib, new HashSet<>());
        }
        return res;
    }

private double dfs(String curr, String target, Map<String, Map<String, Double>> neib, HashSet<String> visited) {
        if (!neib.containsKey(curr))
            return -1; //no element in graph at all (x/x in first example)
        visited.add(curr);
        if (curr.equals(target))
            return 1;
        for (Map.Entry<String, Double> entry : neib.get(curr).entrySet()) {
            if (visited.contains(entry.getKey())) continue;
            double res = dfs(entry.getKey(), target, neib, visited);
            if (res > 0) 
                return res * entry.getValue();
        }
        return -1; //no correlation between curr and target found 
    }
}