class Solution {
    public boolean buddyStrings(String s, String goal) {
	if (s.length() != goal.length())
		return false;
	if (s.equals(goal) && hasDuplicateChars(s))
		return true;

	var diffs = findDiffs(s, goal);
	return diffs.size() == 2 &&
		   s.charAt(diffs.getFirst()) == goal.charAt(diffs.getLast()) &&
		   s.charAt(diffs.getLast()) == goal.charAt(diffs.getFirst());
}

private boolean hasDuplicateChars(String s) {
	var chars = new HashSet<Character>();
	return IntStream.range(0, s.length())
					.anyMatch(i -> !chars.add(s.charAt(i)));
}

private Deque<Integer> findDiffs(String s, String goal) {
	var diffs = new ArrayDeque<Integer>();

	for (var i = 0; i < s.length(); i++)
		if (s.charAt(i) != goal.charAt(i)) {
			diffs.add(i);
			if (diffs.size() > 2)
				break;
		}

	return diffs;
}
}