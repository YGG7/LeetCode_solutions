package JavaFeatures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put("s", 1);
        map.put("s", 2); // subsequent insertion with the same key will overwrite the previous key-value pair
        System.out.println(map.toString());
    }
}
