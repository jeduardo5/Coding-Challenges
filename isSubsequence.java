class Solution {
    public boolean isSubsequence(String s, String t) {
      if (s.length() == 0 )
          return true;
        int index1 = 0, index2 = 0;
        
        while ( index2 < t.length()){
            if (t.charAt(index2) == s.charAt(index1)){
                index1++;
                if (index1 == s.length()) return true;
            }
            index2++;
        }
        return false;
    }
}
