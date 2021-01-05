package LeetCode;

/**
 * Jianzhi 19. https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 */
public class RegExpMatch {
    public boolean isMatch(String s, String p) {
//        return isMatchRecur(s.toCharArray(), p.toCharArray(), s.length()-1, p.length()-1);
        return isMatchDP(s.toCharArray(), p.toCharArray());
    }

    private boolean isMatchDP(char[] s, char[] p) {
        int m = s.length, n = p.length;
        boolean[][] res = new boolean[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0&&j==0) res[i][j] = true; // empty string & empty pattern
                else if(j==0) res[i][j] = false; // only empty pattern
                else if(i==0) {                  // only empty string
                    if(p[j-1]=='*') res[i][j] = res[i][j-2];
                    else res[i][j] = false;
                }
                else {
                    // assume regular expression is valid
                    if(p[j-1]=='*') {
                        if(p[j-2]=='.' || p[j-2]==s[i-1]) res[i][j] = res[i][j-2] || res[i-1][j];
                        else res[i][j] = res[i][j-2];
                    }
                    else if(p[j-1]=='.' || p[j-1]==s[i-1]) res[i][j] = res[i-1][j-1];
                    else res[i][j] = false;
                }
            }
        }
        return res[m][n];
    }

    private boolean isMatchRecur(char[] s, char[] p, int sIdx, int pIdx) {
        if(pIdx<0 && sIdx<0) return true; // empty pattern & empty string
        else if(pIdx<0) return false; // only empty pattern
        else if(sIdx<0) { // only empty string
          if(p[pIdx]=='*') return isMatchRecur(s, p, sIdx, pIdx-2);
          else return false;
        }
        else {
            if(p[pIdx]=='*') {
                if(pIdx<1) return false; // invalid pattern
                else if(s[sIdx] == p[pIdx-1] || p[pIdx-1] == '.') return isMatchRecur(s, p, sIdx-1, pIdx) || isMatchRecur(s, p, sIdx, pIdx-2);
                else return isMatchRecur(s, p, sIdx, pIdx-2);
            }else if(p[pIdx]=='.' || p[pIdx]==s[sIdx]) return isMatchRecur(s, p, sIdx-1, pIdx-1);
            else return false;
        }
    }
}
