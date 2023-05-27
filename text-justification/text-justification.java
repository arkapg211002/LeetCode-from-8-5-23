class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        List<String> row = new ArrayList<String>();
        int index = 0, len = 0;
        while (index < words.length) {
            String word = words[index];
            if ((row.size() == 0 && len + word.length() > maxWidth) 
                || (row.size() > 0 && len + word.length() + 1 > maxWidth)) {
                result.add(formatHelper(row, len, maxWidth, false));
                row = new ArrayList<String>();
                len = 0;
            } else {
                row.add(word);
                if (len == 0) {
                    len += word.length();
                } else {
                    len += (word.length() + 1);
                }
                index++;
            }
        }
        if (!row.isEmpty()) {
            result.add(formatHelper(row, len, maxWidth, true));
        }
        return result;
    }

    private String formatHelper(List<String> row, int len, int maxWidth, boolean isLastRow) {
        StringBuilder result = new StringBuilder();
        int diff = maxWidth - len;
        int interLen = (row.size() > 1) ? (diff / (row.size() - 1)) : diff;
        StringBuilder interString = new StringBuilder();
        for (int i = 0; i < interLen; i++) {
            interString.append(" ");
        }
        int largerInterCount = diff - interLen * (row.size() == 1 ? 1 : (row.size() - 1));
        for (int i = 0; i < row.size(); i++) {
            result.append(row.get(i));
            if (isLastRow) {
                if (i < row.size() - 1) {
                    result.append(" ");
                }
            } else if (i < row.size() - 1 || row.size() == 1) {
                if (i < row.size() - 1) {
                    result.append(" ");
                }
                result.append(interString);
                if (largerInterCount-- > 0) {
                    result.append(" ");
                }
            }
        }
        if (isLastRow) {
            while (result.length() < maxWidth) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}