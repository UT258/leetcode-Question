class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
         sort(players.begin(),players.end());
         sort(trainers.begin(),trainers.end());
        int j=0;
        int i=0;
        int count=0;
        while(i<players.size() && j<trainers.size())
        {
            if(players[i]<=trainers[j])
            {
                count++;
                i++;
                j++;

            }
            else{
                j++;
                //if players is larger j cannnot be 
            }
             
        }
        return count;
    }
};