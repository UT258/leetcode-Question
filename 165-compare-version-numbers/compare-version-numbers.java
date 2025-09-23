class Solution {
    public int compareVersion(String version1, String version2) {
         String first[] = version1.split("\\.");
        String sec[] = version2.split("\\.");

        if(first.length < sec.length) {  
            String temp[] = new String[sec.length];
            for(int i = 0; i < first.length; i++) {
                temp[i] = first[i];
            }
            for(int i = first.length; i < sec.length; i++) {
                temp[i] = "0";
            }
            first = temp;
        }

        if(sec.length < first.length) {
            String temp[] = new String[first.length];
            for(int i = 0; i < sec.length; i++) {
                temp[i] = sec[i];
            }
            for(int i = sec.length; i < first.length; i++) {
                temp[i] = "0";
            }
            sec = temp;
        }

        for(int i = 0; i < sec.length; i++) {
            int f = Integer.parseInt(first[i]);
            int s = Integer.parseInt(sec[i]);
            if(f < s) return -1;
            if(f > s) return 1;
        }
        return 0;
    }
}