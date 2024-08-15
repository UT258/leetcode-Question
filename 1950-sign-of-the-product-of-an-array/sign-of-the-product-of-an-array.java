class Solution {
    public int arraySign(int[] nums) {
        int neg=0;
        for(int n:nums)
        {
            if (n==0)
            {
                return 0 ;//since we  are concerned about product everthing will be 0  if there is zero

            }
            if(n<0){
                neg++;
            }
           

        }
         if (neg % 2 ==0)
            {
                return 1;
            }

        return -1;//if none of this work
        
    }
}