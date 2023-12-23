class Solution {
    public boolean isPathCrossing(String path) {
	var visited = new HashSet<>(Set.of("0,0"));
	
	for (int x = 0, y = 0, i = 0; i < path.length(); i++) {
		switch (path.charAt(i)) {
			case 'N' -> y++;
			case 'S' -> y--;
			case 'E' -> x++;
			case 'W' -> x--;
		}
		if (!visited.add(x + "," + y))
			return true;
	}
	return false;
}
}