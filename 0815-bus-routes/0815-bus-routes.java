class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();

        queue.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!queue.isEmpty()) {
            int stopsAtThisLevel = queue.size();

            for (int i = 0; i < stopsAtThisLevel; i++) {
                int currentStop = queue.poll();

                List<Integer> busesAtStop = stopToRoutes.get(currentStop);

                for (int bus : busesAtStop) {
                    if (visitedRoutes.contains(bus)) continue;

                    visitedRoutes.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (visitedStops.contains(nextStop)) continue;

                        visitedStops.add(nextStop);

                        if (nextStop == target) return buses + 1;

                        queue.offer(nextStop);
                    }
                }
            }

            buses++;
        }

        return -1;
    }
}