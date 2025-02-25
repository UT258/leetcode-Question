class Solution {
    public int numOfSubarrays(int[] arr) {
          int MOD = (int) Math.pow(10, 9) + 7;
        int pref[]=new int [arr.length];
        pref[0]=arr[0];//intialize with the first element
        for(int i=1;i<arr.length;i++)
        {
            pref[i]=pref[i-1]+arr[i];
        }
        int count=0;
        int even=1;
        int odd=0;
        for(int i=0;i<arr.length;i++)
        {
            if(pref[i]%2!=0)
            {
                //if odd odd+even =odd
                count=(count+even)%MOD;
                odd++;
            }
            else{
                count=(count+odd)%MOD;
                even++;
            }
        }
        return count;
        
    }
}