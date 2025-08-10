class Solution {
  private  String code(int n)
    {
        char arr[]=String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public boolean reorderedPowerOf2(int n) {
        String curr=code(n);
        for(int i=0;i<31;i++)
        {
            int pow = 1<<i; //(int) Math.pow(2,i)
            if(curr.equals(code(pow))){
                return true;
            }
        } 
        return false;
    }
}