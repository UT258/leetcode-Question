class Solution {
    public int[] sortArray(int[] nums) {
        return mergesort(nums);
        //using merge sort 

        
    }
    public int [] mergesort(int arr[])
    {
        //base case 
        if(arr.length==1)
        {
            return arr;//when the array has only one element then return the element

        }
        //divide array
        int mid=arr.length/2;
        int left[]=mergesort(Arrays.copyOfRange(arr,0,mid));
        int right[]=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);


    }
    public int [] merge(int left[],int right[])
    {
        int i=0;
        int j=0;
        int k=0;
        int ans[]=new int [left.length+right.length];
        while(i<left.length  && j<right.length)
        {
            //compare the element of left and right array and put the smaller element in the ans array
                //keep doing the comparison until one of the array is empty
                if(left[i]<right[j])
                {
                    //if left element is smaller put it in the ans
                    ans[k]=left[i];
                    //move the i  note only move the pointer of the array if the element is used
                    i++;
                    k++;
                }
                else{
                    //if right element is smaller put it in the ans
                    ans[k]=right[j];
                    //move the j  note only move the pointer of the array if the element is used
                    j++;
                    k++;
                }


        }
        //now here put all the element that are remaining in the left array
        while(i<left.length)
        {
            ans[k]=left[i];
            i++;
            k++;
        }
        //now here put all the element that are remaining in the right array
        while(j<right.length)
        {
            ans[k]=right[j];
            j++;
            k++;
        }
        return ans;
    }
}