class Solution {
    public int maximum69Number (int num) {
        String s=Integer.toString(num);
        char arr[]=s.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='6')
            {
                //convert it to 9
                arr[i]='9';
                break;// only one change allowed
            }
        }
        s=new String(arr);
        return Integer.parseInt(s);
        
    }
}