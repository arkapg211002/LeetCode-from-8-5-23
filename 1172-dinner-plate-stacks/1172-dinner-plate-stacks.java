class DinnerPlates {

    List<Stack<Integer>> st;
    int c;
    int lastStack = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public DinnerPlates(int capacity) {
        st = new ArrayList<>();
        st.add(new Stack<Integer>());
        c = capacity;
    }
    
    public void push(int val) {
        if(pq.isEmpty() || !pq.isEmpty() && (pq.peek() > lastStack)){
            if(st.get(lastStack).size() == c){
                st.add(new Stack<Integer>());
                lastStack++;
                st.get(lastStack).push(val);

            }else{
                st.get(lastStack).push(val);
            }

        }else{
            st.get(pq.poll()).push(val);
        }
        
    }
    
    public int pop() {
        if(st.get(lastStack).size() == 0){
            return -1;
        }
        int ans = st.get(lastStack).pop();
        // if(st.get(lastStack).size() == 0 && lastStack > 0){
        //     lastStack--;
        // }
        while(st.get(lastStack).size() == 0 && lastStack > 0){
            lastStack--;
        }
        return ans;
    }
    
    public int popAtStack(int index) {
        if(index > lastStack){
            return -1;
        }
        if(st.get(index).size() == 0){
            return -1;
        }
        if(index == lastStack && st.get(index).size() == 1){
            lastStack--;
            return st.get(index).pop();
        }
        pq.offer(index);
        return st.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */