
class Solution {
    HashMap<Pair<Integer, Integer>, Double>h= new HashMap<>();
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        n=(n+24)/25;
        return dp(n,n);
    }
    public double dp(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        Pair<Integer,Integer>key=new Pair<>(a, b);
        if (h.containsKey(key)) return h.get(key);
        h.put(key, 0.25 * (dp(a-4, b) + dp(a-3, b-1) + dp(a-2, b-2) + dp(a-1, b-3)));
        return h.get(key);
    }
}