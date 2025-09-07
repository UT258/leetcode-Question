class Solution {
    public int[] sumZero(int n) {
        int arr[]=new int[n];
        int a=n;
      int  end=n/2+1;
        for(int i=0;i<n/2;i++)
        {
            arr[i]=a;
            a--;
        }
        a=n;
        if(n%2==0)
        {
             end=n/2;
        }
        for(int i=end;i<n;i++)
        {
         arr[i]=-1*a;
         a--;
        }
        return arr;
        
    }
}