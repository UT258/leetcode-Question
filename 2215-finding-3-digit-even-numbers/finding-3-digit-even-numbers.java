class Solution {
    public int[] findEvenNumbers(int[] digits) {
        //now optimal method 
        List<Integer>list=new ArrayList<>();
         int map[]=new int [10];
         for(int n:digits)
         {
            map[n]++;
         }
        for(int i=1;i<=9;i++)
        {
          if (map[i]==0)continue;
          map[i]--;
          for(int j=0;j<=9;j++)
          {
            if(map[j]==0) continue;
             map[j]--;
             for(int k=0;k<=8;k+=2)
             {
                if(map[k]==0)continue;
                map[k]--;
                int num=i*100 +j*10 +k;
                 list.add(num);
                 map[k]++;
             }
             map[j]++;

          }
          map[i]++;
        }
       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}