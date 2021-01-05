package LeetCode;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0 || popped.length==0) return true;
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0; i<pushed.length; i++) {
            stack.push(pushed[i]);
            while(j<popped.length && !stack.isEmpty() && stack.peek()==popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
