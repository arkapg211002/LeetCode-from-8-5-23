class MyCircularDeque {

    int capacity;
    int size = 0;
    int[] arr;

    public MyCircularDeque(int k) {
        capacity = k;
        arr = new int[k];    
    }
    
    public boolean insertFront(int value) {
        if(size==capacity) return false;
        for (int i = size; i>0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==capacity) return false;
        arr[size++]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        arr[size-1]=0;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;
        return arr[0];        
    }
    
    public int getRear() {
        if(size==0) return -1;
        return arr[size-1];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */