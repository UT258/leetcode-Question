class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
           //two pointer problem 
            //take 4 from the front and  0 from the back
            //take3 from the front and 1 from the back
            int lsum=0;
            int rsum=0;
            //calulate the left sum by adding k from the front
            for(int i=0;i<k;i++)
            {
               lsum+=cardPoints[i];

            }
            int maxsum=lsum;
            int j=cardPoints.length-1;
        for(int i=0;i<k;i++)

        {
            //remove the last k the element from the left sum and add the last element from the rigth sum
            lsum=lsum-cardPoints[k-1-i];
            rsum+=cardPoints[j-i];
            maxsum=Math.max(maxsum,lsum+rsum);

        }
        return maxsum;
            

    }
}