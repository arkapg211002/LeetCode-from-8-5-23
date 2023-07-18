class LRUCache {
    
    public HashMap<Integer, Node> map;
    public DoubleList cache;
    public int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteKey(key);
            addRecently(key,value);
            return;
        }
        
        if(cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key,value);
    }
    
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }
    
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }
    
    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    
    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirst();
        map.remove(deletedNode.key);
    }
    
    // Node Class
    class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // DoubleList Class
    class DoubleList {
        private Node head, tail;
        private int size;
        
        public DoubleList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        public void addLast(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
            size++;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public Node removeFirst() {
            if(head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }
        
        public int size() {
            return size;
        }
    }
}