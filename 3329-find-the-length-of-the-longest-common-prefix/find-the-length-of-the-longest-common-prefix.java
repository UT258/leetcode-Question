class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String,Integer>map=new HashMap<>();
        for(int n:arr1)
        {
            String temp=Integer.toString(n);
            String prefix="";
            for(char c:temp.toCharArray())
            {
                prefix+=c;//added in the prefix
                map.put(prefix,map.getOrDefault(prefix,0)+1);

            }
        }
        int max=0;
        for(int n:arr2){
            String temp=Integer.toString(n);
            String prefix="";
            for(char c:temp.toCharArray())
            {
                prefix+=c;//added in the prefix
                if(map.containsKey(prefix))
                {
                    max=Math.max(max,prefix.length());
                }

            }
        }
        return  max;
    }
}