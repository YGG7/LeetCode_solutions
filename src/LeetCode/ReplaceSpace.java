package LeetCode;

import java.util.ArrayList;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] replacedS = new char[3*len];
        int size = 0;
        for (int i=0;i<len;i++) {
            if(s.charAt(i) == ' ') {
                replacedS[size++] = '%';
                replacedS[size++] = '2';
                replacedS[size++] = '0';
            } else {
                replacedS[size++] = s.charAt(i);
            }
        }
        return new String(replacedS, 0, size);
    }

    // Dynamically allocate space by StringBuilder
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()) {
            if (c==' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // API
    public String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }

}
