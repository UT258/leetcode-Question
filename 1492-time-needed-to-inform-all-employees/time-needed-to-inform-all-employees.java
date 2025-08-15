class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Build adjacency list for subordinates
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }
        
        // BFS queue: store {employeeID, timeTakenSoFar}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        
        int maxTime = 0;
        
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int empID = front[0];
            int timeSoFar = front[1];
            
            // Update max time
           
            
            // Push all subordinates with updated time
            for (Integer sub : adj.get(empID)) {
                q.add(new int[]{sub, timeSoFar + informTime[empID]});
            }
             maxTime = Math.max(maxTime, timeSoFar);
        }
        
        return maxTime;
    }
}
