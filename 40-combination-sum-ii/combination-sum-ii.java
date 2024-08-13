class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<>();//for the current traversal
        Arrays.sort(candidates);//for duplicates 
        solve(candidates,target,curr,result,0);
        return result;
   
    }
    private void solve(int []arr,int target,ArrayList<Integer>curr,List<List<Integer>> result,int i)
    {
         if(target<0)
         {
            return ;//if it is negative return from there it cannot ne the answer
         }
        if(target==0)
        {
            result.add(new ArrayList<>(curr));//if target is zero we got the sum
            
        }
        for(int j=i;j<arr.length;j++)
        {   if(j>i && arr[j-1]==arr[j])
        {
            continue ;//for duplicates 
        }
            curr.add(arr[j]);//add it in the answer
            solve(arr,target-arr[j],curr,result,j+1);//call for the reamining 
            curr.remove(curr.size()-1);//remove the last element that was added

        }
        
    }
}