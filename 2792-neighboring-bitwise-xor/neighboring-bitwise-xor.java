class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int n:derived)
        {
            xor=xor ^ n;
        }
        return xor==0;
    }
}