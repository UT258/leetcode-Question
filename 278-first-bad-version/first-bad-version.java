/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        while(start<end)
        {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid))
            {
                //if it is a bad version after it will be too
                end=mid;
            }
            else{
                start=mid+1;
            }        
        }
        return start;
        
    }
}