class Solution {
    public int largestCombination(int[] candidates) {
    //to make the bit the >0 just check all the bits 
    int bitcount[]=new int [32];
    //calculate no of bits req to represent the number
    //log2()+1
    //it will take around 24 
    int max=0;
    for(int i=0;i<32;i++)
    {
        for(int num :candidates)

        {
            //we will find the number of set bit for the i the pos of every number 
            if((num &  (1<<i))!=0)

            {
                bitcount[i]++;
            }
        }
       //here i will have the bit count for this pos
       max=Math.max(max,bitcount[i]);
    }
    return max;
        
    }
}