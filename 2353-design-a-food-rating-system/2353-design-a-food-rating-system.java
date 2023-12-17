import java.util.HashMap;
import java.util.PriorityQueue;

public class FoodRatings {

    public class FoodPair {
        String foodName;
        int foodIndex;
        int foodRating;

        public FoodPair(String food, int index, int rating) {
            foodName = food;
            foodIndex = index;
            foodRating = rating;
        }
    }

    private HashMap<String, Integer> foodIndexMap = new HashMap<>();
    private HashMap<String, PriorityQueue<FoodPair>> cuisinePriorityQueueMap = new HashMap<>();
    private int[] foodRatings;
    private String[] foodNames;
    private String[] cuisines;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            cuisinePriorityQueueMap.putIfAbsent(cuisines[i], new PriorityQueue<>(Comparator.comparing(
                    (FoodPair a) -> a.foodRating).reversed().thenComparing(a -> a.foodName)));
            cuisinePriorityQueueMap.get(cuisines[i]).offer(new FoodPair(foods[i], i, ratings[i]));
            foodIndexMap.put(foods[i], i);
            foodRatings = ratings;
            foodNames = foods;
            this.cuisines = cuisines;
        }
    }

    public void changeRating(String food, int newRating) {
        int index = foodIndexMap.get(food);
        foodRatings[index] = newRating;
        String cuisine = cuisines[index];
        cuisinePriorityQueueMap.get(cuisine).offer(new FoodPair(foodNames[index], index, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodPair> cuisinePriorityQueue = cuisinePriorityQueueMap.get(cuisine);
        while (foodRatings[cuisinePriorityQueue.peek().foodIndex] != cuisinePriorityQueue.peek().foodRating) {
            cuisinePriorityQueue.poll();
        }
        return cuisinePriorityQueue.peek().foodName;
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */