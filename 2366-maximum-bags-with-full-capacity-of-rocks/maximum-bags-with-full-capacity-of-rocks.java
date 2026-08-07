class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //find the diff 
        int count=0;
        for(int i=0;i<rocks.length;i++)
        {
            capacity[i]-=rocks[i];
        }
        Arrays.sort(capacity);
        for(int i=0;i<rocks.length;i++)
        {
            //first try to complete the capacirt that need the min rocks first

            if(capacity[i]<=additionalRocks)
            {
                //i can fill this bag completeyy
                count++;
                additionalRocks-=capacity[i];
            }
            else{
                break;
            }
        }
        return count;
        
    }
}