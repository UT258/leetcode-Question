class Solution {
    public String[] sortPeople(String[] names, int[] height) {
        //using bubble sort aproach 
        for(int i=0;i<names.length-1;i++)
        {
            for(int j=i+1;j<names.length;j++)
            {
                //check the descending order
                if(height[i]<height[j])
                {
                   //if it is smaller we need to swap
                    int temp=height[i];
                    height[i]=height[j];
                    height[j]=temp;
                    swap(i,j,names);
                }
            }
        }
        //in the end return the names array
        return names;
        
    }
    private void swap(int a ,int b,String arr[])
    {
        String temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp; //using refrence
    }
}