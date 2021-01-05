package noteSWE241P;

public class StringPatternMatching {
    public static void main(String[] args) {
        String s = "agasdgs", p = "gas";
        System.out.println(match(s, p));
    }

    public static int match(String s, String pattern) {
        int slen = s.length(), pattenlen = pattern.length();
        if (slen<pattenlen) return -1;

        for (int i=0; i<=slen-pattenlen; i++) {
            int matchlen = 0;
            while (matchlen<pattenlen && pattern.charAt(matchlen) == s.charAt(i+matchlen)) {
                matchlen +=1;
            }
            if (matchlen==pattenlen) return i;
        }
        return -1;
    }
}
