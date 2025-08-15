class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] inform) {
        int[] memo = new int[n]; // Memoization array to store calculated inform times
        
        int max = 0;
        for(int i = 0; i < n; i++ ){
            max = Math.max(max, find(i, manager, inform, memo));
        }

        return max;
    }


    public int find(int x, int[] manager, int[] inform, int[] memo){
        if(manager[x] == -1){//the employee is a manger so return the return time of just the manager
            return inform[x];
        }
        
        if(memo[x] != 0) { // If the inform time is already calculated and stored in the memo array, return it
            return memo[x];
        }
        //calculate the inform time of the employee and the managers of the employee
        int time = inform[x] + find(manager[x], manager, inform, memo);
        memo[x] = time; // Store the calculated inform time in the memo array
        
        return time;
    }
}