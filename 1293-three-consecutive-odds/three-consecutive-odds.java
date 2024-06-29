class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        //count the consecutive odd number
        int count=0;
        for(int n:arr)
        {
            if(n%2!=0)
            {
                count++;
            }
            else{
                count=0;
            }
            if(count==3)
            {
                return true;
            }
        }
        return false;
        
    }
}