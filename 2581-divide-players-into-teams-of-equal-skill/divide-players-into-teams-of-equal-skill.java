class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int target=skill[0]+skill[skill.length-1];
        long sum=0;
        for(int i=0;i<skill.length/2;i++)
        {
            if(skill[i]+skill[skill.length-1-i]!=target)
            {
                return -1;
            }
            sum+=skill[i]*skill[skill.length-1-i];
            
        }
        return sum;

        
    }
}