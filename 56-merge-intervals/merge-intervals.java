class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,
                (a, b) -> (Integer.compare(a[0], b[0])));
        //sort using starting interval 
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(!ans.isEmpty() && ans.get(ans.size()-1)[1] >=end)
            {

                continue;//already inside
            }
            for(int j=i+1;j<n;j++)
            {
                if(intervals[j][0]<=end)
                {
                    end=Math.max(intervals[j][1],end);
                }
                else{
                    //if you did not find here you will not find it after as well the array is sorted
                    break;
                }
            }
            ans.add(new int[]{ start,end});


        }
        //conver this list to 2d array 
        int arr[][] = new int[ans.size()][2];
        int ind = 0;
        for (int[] curr : ans) {
            arr[ind++] = curr;
        }
        return arr;

    }
}