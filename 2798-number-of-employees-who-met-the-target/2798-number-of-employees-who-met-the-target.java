class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        Arrays.sort(hours);
        int l=0,r=hours.length-1,id=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(hours[mid]>=target)
            {
                id=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        if(id!=-1) return hours.length-id;
        else return 0;
    }
}