class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);
        // take two pointer one for the answer array and one for traversing
        int i = 0;
        int j = 0;
        boolean isalternate = false;
        int ans[] = new int[deck.length];
        while (i < deck.length) {
            if (ans[j] == 0) {
                if (!isalternate) {
                    ans[j] = deck[i];

                    // deck of i must be zero that determine that i can put the number here
                    i++;// only increase the i when it is place
                }
                isalternate = !isalternate;

            }

            // make alternate

            // increase the j
            j = (j + 1) % deck.length;// to move in circles

        }
        return ans;

    }
}