class Solution {
    public int solve(String s,int l,int r,int arr[][])
    
    {
        if(l==r)
        {
            return 1;//there is only one character

        }
        if(l>r)
        {
            return 0;
        }
        if(arr[l][r]!=-1)
        {
           return arr[l][r];
        }
        int i=l+1;//point to the first equal element
        
        while(i<=r && s.charAt(i)==l)
        {
            i++;//i points to first number that is not equal to first one
        }
        if(i==r+1)
        {
            //means from l to r all all are equal
            return 1;//you can print it in one go 
        }
        int normal=1+solve(s,i,r,arr);
        int rem=Integer.MAX_VALUE;
        for(int j=i;j<=r;j++)
        {
            if (s.charAt(j)==s.charAt(l))
            {
                int x=solve(s,i,j-1,arr)+solve(s,j,r,arr);
                rem=Math.min(x,rem);
            }

        }
        arr[l][r]= Math.min(normal,rem);
        return arr[l][r];
    }
    public int strangePrinter(String s) {
        int arr[][]=new int [s.length()+1][s.length()+1];
        for(int temp[]:arr)
        {
            Arrays.fill(temp,-1);
        }
        
        return solve(s,0,s.length()-1,arr);
        
        
    }
}