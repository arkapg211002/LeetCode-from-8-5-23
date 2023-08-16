class ProductOfNumbers {
    ArrayList<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList();
    }
    public void add(int num) {
        if(num == 0){
            prefixProduct.clear();
        }
        else{
            int sz = prefixProduct.size();
            if(sz == 0)
                prefixProduct.add(num);
            else
                prefixProduct.add(num*prefixProduct.get(sz-1));
        }
    }
    
    public int getProduct(int k) {
        int sz = prefixProduct.size();
        if(k>sz)
            return 0;
        if(k==sz)
            return prefixProduct.get(sz-1);
        else
            return prefixProduct.get(sz-1)/prefixProduct.get(sz-k-1);
    }
}