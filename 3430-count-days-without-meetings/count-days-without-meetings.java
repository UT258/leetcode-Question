class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,Comparator.comparingInt(e -> e[0]));
        int start=0;
        int end=0;
        int res=0;
        for(int arr[]:meetings)
        {
            if(arr[0]>end)

            {
            //if the starting is greate than end
            res+=arr[0]-end-1;
            }
            end=Math.max(end,arr[1]);
        }
        if(end<days)
        {
            //it means there are still some days left
            res+=days-end;
        }
        return res;
    }
}