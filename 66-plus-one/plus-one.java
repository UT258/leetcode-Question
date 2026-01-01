class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(i>=0)
        {
            if(digits[i]<9)
            {
                digits[i]+=1;
                return digits;
            }
            else{
                digits[i]=0;
                i--;
            }
        }
        
        int temp[]=new int[digits.length+1];
        temp[0]=1;
        return temp;
    }
}