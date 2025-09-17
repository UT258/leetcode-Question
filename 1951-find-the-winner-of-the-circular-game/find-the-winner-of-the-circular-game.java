class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        int ind=0;
        while(list.size()>1)
        {
             ind=(ind+k-1)%list.size();
             list.remove(ind);
             
        }
        return list.get(0);
    }
}