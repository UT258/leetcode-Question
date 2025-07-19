class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //create a avg 
        double avg=Double.NEGATIVE_INFINITY;
        int i=0;
        int j=0;
        double sum=0;
        while(j<nums.length)
        {
            sum +=nums[j];
            //update the size if it equal to the size of the window
            int l=j-i+1;
            if(l==k)
            {
             //calulate the avg 
             double CurrAvg=sum/l;
               avg=Math.max(avg ,CurrAvg);
               //move the window now already find the answer
               sum-=nums[i];
               i++;

            }
            
            j++;//increase overall window
        }
     return avg;
        
    }
}