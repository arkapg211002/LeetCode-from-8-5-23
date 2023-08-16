class DataStream {

    int val, main, count;
    public DataStream(int value, int k) {
        val = value;
        main = k;
        count = 0;
    }

    public boolean consec(int num) {
        if (num == val) count++;
        else count = 0;
        return count >= main;
    }
}