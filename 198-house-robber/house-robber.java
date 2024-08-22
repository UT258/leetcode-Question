class Solution {
    public int rob(int[] nums) {
        //bottom up aproach
        int t[]=new int [nums.length+1];
         t[0]=0;//profit till 0 house no house no profit
        t[1]=nums[0];
        for(int i=2;i<=nums.length;i++)
        {
            int steal=nums[i-1]+t[i-2]; //if i steal i cannot take profit of i-1 cuz its adjacent
            int skip=t[i-1];//if we didnt steal i can take that profit
            t[i]=Math.max(steal,skip);

        }
        return t[nums.length];
        
    }
}