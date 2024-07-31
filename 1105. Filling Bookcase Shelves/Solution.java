// https://leetcode.com/problems/filling-bookcase-shelves/description/?envType=daily-question&envId=2024-07-31

class Solution {
  int[][] memo;

  private int backtrack(int[][] books, int shelfWidth, int widthRemaining, int i, int maxShelfHeight) {
    if (i == books.length) return 0;

    if (memo[i][widthRemaining] != 0)
      return memo[i][widthRemaining];

    var thickness = books[i][0];
    var height = books[i][1];

    var minHeight = height + backtrack(books, shelfWidth, shelfWidth - thickness, i+1, height);
    var altMinHeight = Integer.MAX_VALUE;

    if (widthRemaining >= thickness) {
      altMinHeight =
        Math.max(height - maxShelfHeight, 0) +
          backtrack(books, shelfWidth, widthRemaining - thickness, i+1, Math.max(maxShelfHeight, height));
    }
    memo[i][widthRemaining] = Math.min(minHeight, altMinHeight);
    return memo[i][widthRemaining];
  }

  public int minHeightShelves(int[][] books, int shelfWidth) {
    memo = new int[books.length][shelfWidth + 1];

    return backtrack(books, shelfWidth, shelfWidth, 0, 0);
  }
}
