class MKAverage {

    Queue<Integer> q;
    int sum;
    TreeMap<Integer, Integer> map;
    int size;
    int k;
    public MKAverage(int m, int x) {
        size = m;
        k = x;
        q = new LinkedList<>();
        map = new TreeMap<>();
        sum = 0;
    }
    
    public void addElement(int num) {
        if(q.size()==size){
            int temp = q.poll();
            map.put(temp, map.getOrDefault(temp, 0)-1);
            if(map.get(temp)<=0) map.remove(temp);
            sum -= temp;
        }
        q.add(num);
        map.put(num, map.getOrDefault(num, 0)+1);
        sum += num;
    }
    
    public int calculateMKAverage() {
        if(q.size() < size) return -1;
        int len = size - 2*k;
        int restSum = 0;
        int i = 0;

        // remove first k element and update sum
        int key = map.firstEntry().getKey();
        while(true){
            int val = map.get(key);
            if(i+val >= k){
                restSum += key * (k-i);
                break;
            } else {
                restSum += key * val;
                i += val;
            }
            key = map.higherKey(key);
        }   
        
        // remove last k element and update sum
        key = map.lastEntry().getKey();
        i=0;
        while(true){
            int val = map.get(key);
            if(i+val >= k){
                restSum += key * (k-i);
                break;
            } else {
                restSum += key * val;
                i+=val;
            }
            key = map.lowerKey(key);
        }
        return (sum - restSum)/len;
    }
}
/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */