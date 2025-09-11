class Solution {
    public boolean vowel(char ch)
    {     ch = Character.toLowerCase(ch);
    
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public String sortVowels(String s) {
        List<Character> list= new ArrayList<>();
        for (char ch : s.toCharArray()) {
           if(vowel(ch))
           {
              list.add(ch);
           }
        }
         Collections.sort(list);
        char str[]=s.toCharArray();
        int j=0;


        for(int i=0;i<str.length;i++)
        {
            if(vowel(str[i]))
            {
               str[i]=list.get(j);
               j++;        
            }
            
        }
        return  new String (str);

    }
}