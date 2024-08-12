class KthLargest {
    //if we need to find kth largest we can use heap min heap
    private PriorityQueue<Integer>heap;
    private int K;

    public KthLargest(int k, int[] nums) {
        K=k;
        heap=new PriorityQueue<>();//intialise the heap
        for(int n :nums)
        {
            heap.offer(n);
            //maintain its size k 
            if(heap.size()>K)
            {
                heap.poll();
            }
        }
        
    }
    
    public int add(int val) {
        //add the element first 
        heap.offer(val);
        if(heap.size()>K)
        {
            heap.poll();
        }
        return heap.peek();//return the top element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */