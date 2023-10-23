class Solution {
public boolean isPowerOfFour(int n) {
    if (n < 1) {
        return false;
    }
    
    boolean isTrue = true;
 
    while(n != 0) {
        int num = n/4;
        if (n > 1 && n%4 != 0) {
            isTrue = false;
        }
        n = num;
    }
    return isTrue;
	}
}