class FoodRatings 
{
    public class Pair
    {
        String f;
        int i;
        int rating;
        public Pair(String food, int index, int ratings)
        {
            f = food;
            i = index;
            rating = ratings;
        }
    }
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, PriorityQueue<Pair>> pqMap = new HashMap<>();
    int[] rates;
    String[] f;
    String[] cus;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings)
    {
        for(int i = 0; i < foods.length; i++)
        {
            pqMap.putIfAbsent(cuisines[i], new PriorityQueue<Pair>((a, b) -> b.rating == a.rating ? a.f.compareTo(b.f) : b.rating - a.rating));
            pqMap.get(cuisines[i]).offer(new Pair(foods[i], i, ratings[i]));
            map.put(foods[i], i);
            rates = ratings;
            f = foods;
            cus = cuisines;
        }
    }
    
    public void changeRating(String food, int newRating) 
    {
        int index = map.get(food);
        rates[index] = newRating;
        String c = cus[index];
        pqMap.get(c).offer(new Pair(f[index], index, newRating));
    }
    
    public String highestRated(String cuisine) 
    {
        PriorityQueue<Pair> pq = pqMap.get(cuisine);
        while(rates[pq.peek().i] != pq.peek().rating)
        {
            pq.poll();
        }    
        return pq.peek().f;
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */