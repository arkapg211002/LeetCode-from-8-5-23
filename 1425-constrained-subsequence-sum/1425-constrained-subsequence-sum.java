class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int arr[]=new int[nums.length];
        arr[arr.length-1]=nums[nums.length-1];
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(nums[nums.length-1]);
        int p=nums.length-1;
        int max=arr[arr.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(i+k>=nums.length-1)
            {
                if(nums[i]+l.get(l.size()-1)>nums[i])
                {
                   arr[i]=nums[i]+l.get(l.size()-1);
                }
                else
                {
                    arr[i]=nums[i];
                }
                if(l.size()==1)
                {
                    if(l.get(0)>arr[i])
                    {
                        l.add(0,arr[i]);
                    }
                    else
                    {
                        l.add(arr[i]);
                    }
                }
                else
                {
                    int low=0,high=l.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>=arr[i])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            low=mid+1;
                            index=mid+1;
                        }
                    }
                    l.add(index,arr[i]);
                }
            }
            else
            {
                 int low=0,high=l.size()-1;
                 while(low<=high)
                 {
                     int mid=(low+high)/2;
                     if(l.get(mid)==arr[p])
                     {
                         l.remove(mid);
                         break;
                     }
                     else if(l.get(mid)>arr[p])
                     {
                         high=mid-1;
                     }
                     else
                     {
                         low=mid+1;
                     }
                 }
                 p--;
                 if((nums[i]+l.get(l.size()-1))>nums[i])
                {
                   arr[i]=nums[i]+l.get(l.size()-1);
                }
                else
                {
                    arr[i]=nums[i];
                }
                if(l.size()==1)
                {
                    if(l.get(0)>arr[i])
                    {
                        l.add(0,arr[i]);
                    }
                    else
                    {
                        l.add(arr[i]);
                    }
                }
                else
                {
                    low=0;
                    high=l.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>=arr[i])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            low=mid+1;
                            index=mid+1;
                        }
                    }
                    l.add(index,arr[i]);
                }

            }
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }

        return max;

    }
}