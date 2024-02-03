class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[]={-1,-1};
    
        int first=Find(nums,target,true);
        int last=Find(nums,target,false);
         if (first!=-1)
         {
             result[0]=first;
             result[1]=last;
             
         }
        
        return result;
        
    }
    int Find(int nums[],int target,boolean left)
    {   int ans=-1;
        int s=0;
        int e=nums.length-1;
        
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if (nums[mid]>target)
            {
                e=mid-1;
            }
            else if (nums[mid]<target)
            {
                s=mid+1;
            }
            else
            {ans=mid;
                if (left)
                {    
                    e=mid-1;

                }
                else{
                    
                    s=mid+1;
                }

            }
            
        }
        return ans;

    }
}