//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:
    // Function to calculate XOR of array elements
    vector<int> getXor(vector<int> A, int N)
    {
        int XOR = 0;
        // calculate XOR of array
        for (int i = 0; i < N; i++)
            XOR ^= A[i];
            
        // update array by XORing each element with XOR
        for (int i = 0; i < N; i++)
            A[i] = XOR ^ A[i];
            
        return A;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N ;
        vector<int> A(N);

        for (int i = 0; i < N; i++)
        {
            cin >> A[i];
        }

        Solution ob;
        vector<int> B = ob.getXor(A, N);
        for(int i = 0 ; i < N ; i++)
        {
            cout << B[i] <<" ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends