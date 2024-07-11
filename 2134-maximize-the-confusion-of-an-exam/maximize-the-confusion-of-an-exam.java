class Solution {
    public int maxConsecutiveAnswers(String answerkey, int k) {
        //simple two pointer problem
        int length=Math.max(maxLen(answerkey,k,'T'),maxLen(answerkey,k,'F'));
        return length;
        
        
    }
   private int maxLen(String answerKey, int k, char ch) {
        int left = 0;
        int maxLength = 0;
        int count = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != ch) {
                count++;
            }

            while (count > k) {
                if (answerKey.charAt(left) != ch) {
                    count--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}