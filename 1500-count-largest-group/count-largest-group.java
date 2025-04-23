class Solution {

    public int sum(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=n%10;
            n=n/10;

        }
        return sum;
    }
    public int countLargestGroup(int n) {
        if(n<10)
        {
            return n;
        }
          HashMap<Integer,Integer>map=new HashMap<>();
         int max=0;
          for(int i=1;i<=n;i++)

          {  int digit=sum(i);
            map.put(digit,map.getOrDefault(digit,0)+1);
            max=Math.max(max,map.get(digit));
          }
          int count=0;
          for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==max)
            {
                count++;
            }
          }
          return count;
    }
}