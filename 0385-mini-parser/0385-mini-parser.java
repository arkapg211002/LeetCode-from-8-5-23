class Solution {
    public NestedInteger deserialize(String s) {
        return run(s, 0, new int[1]).getList().get(0);
    }
    NestedInteger run(String s, int idx, int[] nextidx) {

        int i = idx;
        
        NestedInteger newni = new NestedInteger();
        boolean neg = false;
        while(i < s.length()) {

            char c = s.charAt(i);

            if(isInteger(c)) {
                int v = 0;
                while(i < s.length()  && isInteger(s.charAt(i))) {
                    c = s.charAt(i);
                    v = v * 10 + c - '0';
                    i++;
                }
                i--;
                if(neg) {
                    v = v * -1;
                }
                neg = false;
                NestedInteger ni = new NestedInteger(v);
                newni.add(ni);
            } else if (c == ',') {

            } else if (c == '[') {
                newni.add(run(s, i + 1, nextidx));
                i = nextidx[0];
            } else if (c == ']') {
                nextidx[0] = i;
                return newni;
            } else {
                neg = true;
            }
            i++;
        }
        return newni;
    }
    boolean isInteger(char c) {
        return c >= '0' && c <= '9';
    }
}