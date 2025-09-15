class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count=0;
        String arr[]=text.split(" ");
        System.out.print(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
          boolean check=true;
          for(char ch:brokenLetters.toCharArray())
          {
            if(arr[i].contains(ch+""))
            {
                check=false;
            }
          }
          if(check)
          {
            count++;
          }
        }
        return count;
    }
}