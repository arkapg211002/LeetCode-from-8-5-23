class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n=nums2.length;
        int sol[] = new int [k];

        for (int i= 0; i <= m ; i++){  // number of items taken form nums1 in the solution
            if (i > k || i+n < k) continue;

            int [] nums1contibution = chooseK(nums1,i); 
            int [] nums2contibution = chooseK(nums2,k-i);

            boolean bestSol = false;
            int iter1=0 , iter2=0;

            for (int j=0; j<k ; j++){
                boolean useNums1 = false; 
                if (iter1 == i)  useNums1 = false; 
                else {
                    if (iter2 == k-i) useNums1 = true; 
                    else {
                        if (nums2contibution[iter2] > nums1contibution[iter1]) useNums1 = false; 
                        else if (nums2contibution[iter2] < nums1contibution[iter1]) useNums1 = true; 
                        else useNums1 = firstBigger (nums1contibution,iter1, nums2contibution,iter2);
                    }
                }
                int next = (useNums1) ? nums1contibution[iter1++] : nums2contibution[iter2++];

                if (!bestSol && next < sol[j]) break; // better solution already exist
                if (next > sol[j]) bestSol = true; // this is the best solution so far - write it down to the end
                sol[j] = next; 
            }
        }
        return sol;
    }

    private boolean firstBigger(int[] nums1,int start1, int []nums2, int start2){
        int next1 = nums1[start1] , next2 = nums2[start2];
        while (next1 == next2){
            next1 = (++start1 == nums1.length) ? -1 : nums1[start1];
            next2 = (++start2 == nums2.length) ? -1 : nums2[start2];
            if (next1 == -1) return false;
        }
        return (next1>next2);
    }

    private int[] chooseK(int[] nums, int k) { // choose best k lexicographic order from nums 
        //could be optimaized a lot: given choosek(k) we can use it to calculate choosek(k-1) 
        int [] sol = new int [k];
        int choosen = 0 , iter = 0; // left to choose = k - choosen
        while (choosen < k){
            int max = nums[iter], indexMax = iter;
            for (int i = iter; i + (k - choosen) <= nums.length; i++){
                if (max == 9) break;
                if (nums[i] > max){
                    max = nums[i];
                    indexMax = i;
                }
            }
            iter = indexMax +1; 
            sol[choosen++] = max; 
        }
        return sol;
    }

}