class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //sort the both the array seats and studens
        
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans=0;

        for(int i=0;i<seats.length;i++)
        {
            ans+=Math.abs(students[i]-seats[i]);//calulate the moves

        }
        return ans;
        
    }
}