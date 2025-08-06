class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0;
        int n=people.length;
        int count=0;
        int j=n-1;
        Arrays.sort(people);
        while(i<=j)
        {
            if(people[i]+people[j]<=limit)
            {
                //i can take this person 
                count++;
                i++;
                j--;

            }
            else{
                //if not then take the larger weight person alone
                j--;
                count++;

            }
        }
        return count;
        
    }
}