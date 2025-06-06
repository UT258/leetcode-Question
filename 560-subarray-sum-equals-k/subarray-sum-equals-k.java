class Solution {
    public int subarraySum(int[] nums, int k) {
     HashMap<Integer,Integer>map=new HashMap<>();
     //we need to find the total number of subarray equal k
     int sum=0;
     int c=0;
     map.put(0,1);//this is must
     for(int i=0;i<nums.length;i++)
     {
      //if i have s and i need to find k  i i substract s-k 
      // if s is 6 and k is 3  6 -3 =3 3  will occur one time s-k and the remaing 
     sum+=nums[i];

      int remove=sum-k;
      c+=map.getOrDefault(remove,0);
      map.put(sum,map.getOrDefault(sum,0)+1);
    }
     return c;
        
    }
}