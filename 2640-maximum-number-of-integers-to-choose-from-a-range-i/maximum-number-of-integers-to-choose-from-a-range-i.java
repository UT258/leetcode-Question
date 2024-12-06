class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        //create a map to store the number of the \
        HashSet<Integer>set=new HashSet<>();
        for(int a:banned )
        {
            set.add(a);
        }
        int sum=0;
        int c=0;
        for(int i=1;i<=n;i++)
        {
            if(!set.contains(i) && sum<=maxSum)
            {
                sum+=i;
                if(sum<=maxSum)
                c++;
            }
        }
        return c;
    }
}