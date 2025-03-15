class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxc=0;
        int res=0;
        for(int n:candies)
        {
            maxc=Math.max(maxc,n);
        }
        int start=1;
        int end=maxc;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(cangive(candies,mid,k))
            {
                res=mid;
                //if this much can divide search for the maximum one 
                start=mid+1;

            }
            else{
                //if i cannot distribute even that much then there is no point in searching ahead of it 
                end=mid-1;
            }
        }
        return res;
           
    }
    public boolean cangive(int candies[],int max,long k)
    
    {
        long c=0;
        for(int n:candies)
        {
            c+=n/max;//can we divide this in chunks
            if(c>=k)
            {
                return true; //we can give the k children or more
            }
        }
        return false;
    }
}