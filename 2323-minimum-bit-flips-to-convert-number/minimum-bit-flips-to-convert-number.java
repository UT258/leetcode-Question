class Solution {
    public int minBitFlips(int start, int goal) {
        //we need to change the bit to make it equal 
        //do xor
        int res=start^goal;
        //all same bits will be zero and the remaining set bits will be the
        //result
        return Integer.bitCount(res);
        
    }
}