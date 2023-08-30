class Solution {

long mod = 1000000007;

public int maxNiceDivisors(int n) {
    long ans = 0;
    if(n == 1)
        return 1;
   
    if(n%3 == 0) ans = power(3, n/3);
    if(n%3 == 1) ans = (4*power(3,n/3-1))%mod;
    if(n%3 == 2) ans = (2*power(3,n/3))%mod;
    
    return (int)ans;
    
}

long power(int b, int x){
    if(x == 0)
        return 1;
    
    long ans = power(b, x/2);
    
    
    if(x % 2 != 0)
        return (ans*ans*b)%mod;
    
    return (ans*ans)%mod;
}
}