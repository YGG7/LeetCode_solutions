package LeetCode;

/**
 * Jianzhi 46. https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNumToString {
    public int translateNum(int num) {
        if (num<0) return 0;
        String numString = Integer.toString(num);
        int len = numString.length();
        int oneDigitLess = 1, twoDigitLess = 1;
        for (int i=1; i<len; i++) {
            char a = numString.charAt(i-1), b = numString.charAt(i);
            int tmp = oneDigitLess;
            oneDigitLess = isTranslatable(a,b)?oneDigitLess+twoDigitLess:oneDigitLess;
            twoDigitLess = tmp;
        }
        return oneDigitLess;
    }

    private boolean isTranslatable(char a, char b) {
        return (a=='1'&&b>='0'&&b<='9') || (a=='2'&&b>='0'&&b<='5');
    }
}
