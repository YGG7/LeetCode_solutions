package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class NumberString {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>(){{put(' ', 0);put('s', 1);put('d', 2);put('.', 3);}}, // state 0
                new HashMap<Character, Integer>(){{put('d', 2);put('.', 3);}},                         // state 1
                new HashMap<Character, Integer>(){{put('d', 2);put('.', 3);put('e', 5);put(' ', 8);}}, // state 2
                new HashMap<Character, Integer>(){{put('d', 4);}},                                     // state 3
                new HashMap<Character, Integer>(){{put('d', 4);put('e', 5);put(' ', 8);}},             // state 4
                new HashMap<Character, Integer>(){{put('s', 6);put('d', 7);}},                         // state 5
                new HashMap<Character, Integer>(){{put('d', 7);}},                                     // state 6
                new HashMap<Character, Integer>(){{put('d', 7);put(' ', 8);}},                         // state 7
                new HashMap<Character, Integer>(){{put(' ', 8);}},                                     // state 8
                new HashMap<Character, Integer>(){{put(' ', 0);put('s', 1);put('d', 2);put('.', 3);}}, // state 9 entry
        };
        int currState = 9;
        char type = '?';
        for(char c:s.toCharArray()) {
            if(c==' ' || c=='.') type = c;
            else if(c>='0' && c<='9') type = 'd';
            else if(c=='e' || c=='E') type = 'e';
            else if(c=='-' || c=='+') type = 's';
            else type = '?';
            if(states[currState].containsKey(type)) {
                currState = (int)states[currState].get(type);
            } else {
                return false;
            }
        }
        return currState==2 || currState==3 || currState==4 || currState==7 || currState==8;
    }
}
