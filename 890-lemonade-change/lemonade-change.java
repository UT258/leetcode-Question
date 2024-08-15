class Solution {
    public boolean lemonadeChange(int[] bills) {
        // we need to return the change what can be possibl
        int five = 0;
        int ten = 0;
        for (int n : bills) {
            if (n == 5) {
                five++;
            } else if (n == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    // if five is not greater than 0 then we cannot give the change
                    return false;
                }

            } else if (n == 20) {
                // in this case you have to return 15
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // cuz three fives can also give 15
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        // if none of this work then it possible to give the change
        return true;

    }
}