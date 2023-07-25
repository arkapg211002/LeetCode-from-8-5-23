class Solution {
	public int peakIndexInMountainArray(int[] arr) {
	    int l=0, r=arr.length-1;
		while(l<r)
        {
			int m=(l+r)/2;
            if(arr[m]>arr[m+1] && arr[m]>arr[m-1]) return m;
            else if(arr[m]>arr[m+1]) r=m;
            else l=m+1;
		}
		return -1;
	}
}