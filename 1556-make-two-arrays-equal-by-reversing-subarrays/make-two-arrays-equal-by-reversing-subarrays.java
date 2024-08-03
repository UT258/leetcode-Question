class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for(int i=0;i<target.length;i++)
        {
            //it should be equal
            if(arr[i]!=target[i])

            {
                return false;
            }
        }
        return true;
        
    }
}