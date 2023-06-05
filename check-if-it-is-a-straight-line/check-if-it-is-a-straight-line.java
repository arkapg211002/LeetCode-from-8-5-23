class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
     int x1 = coordinates[0][0],
		x2 = coordinates[1][0],
		y1 = coordinates[0][1],
		y2 = coordinates[1][1];

	// equation = ax + by = c
	int a = (y2 - y1);
	int b = (x1 - x2);
	int c = a * x1 + b * y1;

	for(int i = 2; i < coordinates.length; i++) {
		int cval = a * coordinates[i][0] + b * coordinates[i][1];
		if(cval != c)
			return false;
	}

	return true;   
    }
}