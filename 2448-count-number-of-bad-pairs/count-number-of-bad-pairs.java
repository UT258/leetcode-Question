class Solution {
    public long countBadPairs(int[] nums) {
        long c=0;

         // (nums[i] - i != nums[j] - j). equation can be like this
         //we can count the number of frquency
         for(int i=0;i<nums.length;i++)
         {
            nums[i]=nums[i]-i;
         }
         HashMap<Integer,Integer>map=new HashMap<>();
         for(int i=0;i<nums.length;i++)
         {
            if(map.containsKey(nums[i]))
            {
                //if there is a number that is present in the lhs
                //excluding the number
              c+=i-map.get(nums[i]);  
            }
            else{
                c+=i;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         }
         return c;
    }
}