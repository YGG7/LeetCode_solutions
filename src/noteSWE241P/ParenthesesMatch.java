package noteSWE241P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class ParenthesesMatch {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while ((line=br.readLine())!=null) {
            System.out.println("input string: "+line);
            char[] input = line.trim().toCharArray();
            System.out.println("error index result: "+getFaults(input).toString());
            if (getFaults(input).toString().equals("[]")){
                System.out.println("match result: "+match(input).toString());
            }
        }
    }

    public static ArrayList<Integer> getFaults(char[] input) {
        int len = input.length;
        Stack<Integer> lpar = new Stack<>();
        ArrayList<Integer> errIdx = new ArrayList<>();
        for (int i=0; i<len; i++) {
            if (input[i]=='(') lpar.push(i);
            if (input[i]==')') {
                if (lpar.isEmpty()) {
//                    System.out.println("error at "+i);
                    errIdx.add(i);
                } else {
                    lpar.pop();
                }
            }
        }
        if (lpar.isEmpty()) return errIdx;
        else {
            while(!lpar.isEmpty()) {
                errIdx.add(lpar.pop());
            }
            return errIdx;
        }
    }

    static class indexPair {
        int p1;
        int p2;
        indexPair (int x, int y) {
            p1=x;
            p2=y;
        }

        @Override
        public String toString() {
            return "("+p1+","+p2+")";
        }
    }

    public static ArrayList<indexPair> match(char[] input) {
        int len = input.length;
        Stack<Character> lpar = new Stack<Character>();
        Stack<Integer> lparIdx = new Stack<>();
        ArrayList<indexPair> idxPairList = new ArrayList<indexPair>();

        for (int i=0; i<len; i++) {
            if(input[i]=='('||input[i]=='['||input[i]=='{') {
                lpar.push(input[i]);
                lparIdx.push(i);
            }
            if (input[i]==')'||input[i]==']'||input[i]=='}') {
                if(lpar.peek()==map(input[i])) {
                    lpar.pop();
                    idxPairList.add(new indexPair(lparIdx.pop(), i));
                }
            }
        }
        return idxPairList;
    }

    private static char map(char par) {
        switch (par) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return 'n';
    }


}
