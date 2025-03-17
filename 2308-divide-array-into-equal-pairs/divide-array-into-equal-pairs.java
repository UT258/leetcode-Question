class Solution {
    public boolean divideArray(int[] nums) {
    HashMap<Integer,Integer>map=new HashMap<>();
    for(int n:nums)
    {
        map.put(n,map.getOrDefault(n,0)+1);

    }
    int needpair=nums.length/2;
    int count=0;
    for(int n:nums){
        if(map.get(n)%2!=0)
        {
           return false;//it can considerd be a pair

        }
    }
    return true;
        
    }
}