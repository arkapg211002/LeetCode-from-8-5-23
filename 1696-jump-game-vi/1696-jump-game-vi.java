class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair (K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey () {
        return key;
    }
    
    public V getValue () {
        return value;
    }
}

/*
 * Alternatively, you might want to use javafx.util.Pair and save yourself the trouble
 * javafx is not a part of the standard Java SDK 
*/

class MaxStream<V> {
    private int size;
    private Comparator<V> comparator;
    
    private int counter;
    private Deque<Pair<Integer, V>> q;
    
    public MaxStream (int size, Comparator comparator) {
        this.size = size;
        this.comparator = comparator;
        
        counter = 0;
        q = new ArrayDeque<Pair<Integer, V>>();
    }
    
    public void push (V data) {
        Pair<Integer, V> pair = new Pair (counter++, data);
        if (!q.isEmpty() && q.peek().getKey() < counter - size)
            q.pollFirst ();
        
        while (!q.isEmpty() && comparator.compare(q.peekLast().getValue(), data) == -1) {
            q.pollLast();
        }
        
        q.addLast (pair);
    }
    
    public V poll () {
        return q.peekFirst().getValue ();
    }
}

class Solution {
    public int maxResult(int[] nums, int k) {
        int ans = nums[0];
        MaxStream<Integer> ms = new MaxStream<Integer> (k, new Comparator<Integer>() {
            @Override 
            public int compare (Integer i, Integer j) {
                return i.compareTo(j);
            }
        });
		/*
		 * Alternatively, using a method reference to override and instantiate a functional interface works too
		 * 
		 * Comparator<Integer> comparator = Integer::compare;
		 * MaxStream<Integer> ms = new MaxStream<Integer> (k, comparator);
		*/
        
        for (int i = 1; i < nums.length; ++i) {
			ms.push(ans);
            ans = nums[i] + ms.poll ();
        }
        
        return ans;
    }
}