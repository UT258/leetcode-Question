class Solution {
    private  List<List<Integer>>ans=new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
       helper(nums,0,new ArrayList<>());
       return ans;
        
    }
    public  void helper(int arr[] ,int i,ArrayList<Integer>list)
    {
        if(i==arr.length)
        {
            ans.add(new ArrayList<>(list));
            return ;
        }
        //take it 
        list.add(arr[i]);
        helper(arr,i+1,list);
        //not take it 
        list.remove(list.size()-1);
        helper(arr,i+1,list);
    }
}