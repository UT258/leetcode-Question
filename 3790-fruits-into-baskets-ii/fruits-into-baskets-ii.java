class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans=fruits.length;
        for(int i=0;i<fruits.length;i++)
        {
            for(int j=0;j<baskets.length;j++){
                if(fruits[i]<=baskets[j])
                {
                    ans--;
                    //fruit done
                    baskets[j]=0;//mark it done
                    break;
                }
            }
        }
        return ans;
    }
}