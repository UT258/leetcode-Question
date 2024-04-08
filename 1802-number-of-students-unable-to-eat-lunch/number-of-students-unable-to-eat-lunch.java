class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
         Deque<Integer> st = new LinkedList<>();
    for (int n : students) {
        st.add(n);
    }
    int i = 0;
    int count = 0;
    while (i < sandwiches.length) {
        if (st.getFirst() == sandwiches[i]) {
            st.removeFirst();
            i++;
            count = 0; // Reset the count as a student was able to eat
        } else {
            int temp = st.removeFirst();
            st.addLast(temp);
            count++; // Increment the count as a student was not able to eat
            if (count == st.size()) { // If all students have been moved to the end of the queue
                break; // Break the loop as no more students can eat
            }
        }
    }
    return st.size();
        
    }
}