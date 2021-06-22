package Amazon;

import java.util.*;

/**
 * LC 1152. https://leetcode-cn.com/problems/analyze-user-website-visit-pattern/
 */
public class WebsiteVisitPattern {
    static class Log {
        public String usr;
        public int ts;
        public String web;

        public Log(String _username, int _timestamp, String _website) {
            this.usr = _username;
            this.ts = _timestamp;
            this.web = _website;
        }
    }

    static class ThreeSequence implements Comparable<ThreeSequence> {
        public String s1;
        public String s2;
        public String s3;

        public ThreeSequence(String _s1, String _s2, String _s3) {
            this.s1 = _s1;
            this.s2 = _s2;
            this.s3 = _s3;
        }

        @Override
        public int compareTo(ThreeSequence o) {
            int cmp1 = this.s1.compareTo(o.s1);
            if (cmp1 != 0) return cmp1;
            int cmp2 = this.s2.compareTo(o.s2);
            if (cmp2 != 0) return cmp2;
            return this.s3.compareTo(o.s3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.s1, this.s2, this.s3);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            ThreeSequence oSeq = (ThreeSequence) o;
            return this.s1.equals(oSeq.s1) && this.s2.equals(oSeq.s2) && this.s3.equals(oSeq.s3);
        }
    }

    static class LogComparator implements Comparator<Log> {
        @Override
        public int compare(Log o1, Log o2) {
            return o1.ts - o2.ts;
        }
    }

//    class ThreeSequenceComparator implements Comparator<ThreeSequence> {
//        @Override
//        public int compare(ThreeSequence o1, ThreeSequence o2) {
//            int cmp1 = o1.s1.compareTo(o2.s1);
//            if (cmp1 != 0) return cmp1;
//            int cmp2 = o1.s2.compareTo(o2.s2);
//            if (cmp2 != 0) return cmp2;
//            return o1.s3.compareTo(o2.s3);
//        }
//    }

    public List<String> mostVisitedPattern2(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        List<String> res = new ArrayList<>(3);
        ThreeSequence maxTimesPattern = new ThreeSequence("", "", "");
        Log[] logs = new Log[len];
        int maxVisitor = 0;

        // initialize logs
        for (int i = 0; i < len; i++) {
            logs[i] = new Log(username[i], timestamp[i], website[i]);
        }
        // sort by timestamp
        Arrays.sort(logs, new LogComparator());

        Map<String, List<String>> userVisitMap = new HashMap<>(); // username -> visit path
        Map<ThreeSequence, Integer> patternTimesMap = new HashMap<>(); // pattern -> visit times
        Set<ThreeSequence> sameUserSet = new HashSet<>(); // one pattern can only be counted once under one user
        for (int i = 0; i < len; i++) {
            // getOrDefault: if the given key exists, return the value; otherwise return the default value
            List<String> visitList = userVisitMap.getOrDefault(logs[i].usr, new ArrayList<String>());
            // logs is sorted by timestamp, so elements in each map entry are also sorted
            visitList.add(logs[i].web);
            userVisitMap.put(logs[i].usr, visitList);
        }

        for (String user : userVisitMap.keySet()) {
            List<String> visitList = userVisitMap.get(user);
            int listSize = visitList.size();
            sameUserSet.clear();
            // triple loop, to check every combination
            for (int i = 0; i < listSize - 2; i++) {
                for (int j = i + 1; j < listSize - 1; j++) {
                    for (int k = j + 1; k < listSize; k++) {
                        ThreeSequence tmpSeq = new ThreeSequence(
                                visitList.get(i), visitList.get(j), visitList.get(k));
                        // if this pattern has been counted
                        // ignore other appearances of this pattern under the same user
                        if (sameUserSet.contains(tmpSeq)) continue;

                        sameUserSet.add(tmpSeq);
                        int times = patternTimesMap.getOrDefault(tmpSeq, 0);
                        patternTimesMap.put(tmpSeq, ++times);

                        // find the 3-sequence visited by the largest number of users
                        // and with the smallest lexicographical value
                        if (times > maxVisitor) {
                            maxVisitor = times;
                            maxTimesPattern = tmpSeq;
                        } else if (times == maxVisitor && tmpSeq.compareTo(maxTimesPattern) < 0) {
                            maxTimesPattern = tmpSeq;
                        }
                    }
                }
            }
        }

        res.add(maxTimesPattern.s1);
        res.add(maxTimesPattern.s2);
        res.add(maxTimesPattern.s3);
        return res;
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        List<String> res = new ArrayList<>(3);
        List<String> candidates = new ArrayList<>(); // all path candidates
        Object[] candiArray; // candidate in array-form
        Log[] logs = new Log[len];
        // global map stores the number of different visitors for each path
        Map<String, Integer> map = new HashMap<>();
        int lp = 0, rp = 0;
        int maxVisitor = 0;

        // initialize logs
        for (int i = 0; i < len; i++) {
            logs[i] = new Log(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(logs, (o1, o2) -> {
            int cmp = o1.usr.compareTo(o2.usr);
            if (cmp != 0) return cmp;
            else {
                return o1.ts - o2.ts;
            }
        });
        while (lp < len) {
            if (rp < len && logs[rp].usr.equals(logs[lp].usr)) {
                rp++;
                continue;
            }
            Map<String, Integer> tmpMap = new HashMap<>();
            for (int i = lp; i < rp - 2; i++) {
                for (int j = i + 1; j < rp - 1; j++) {
                    for (int k = j + 1; k < rp; k++) {
                        String key = logs[i].web + "," + logs[j].web + "," + logs[k].web;
                        tmpMap.putIfAbsent(key, 1);
                    }
                }
            }
            for (String key : tmpMap.keySet()) {
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
            lp = rp;
        }

        for (Integer v : map.values()) {
            maxVisitor = Math.max(v, maxVisitor);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVisitor) candidates.add(entry.getKey());
        }
        candiArray = candidates.toArray();
        Arrays.sort(candiArray, (o1, o2) -> {
            return ((String) o1).compareTo((String) o2);
        });
        String path = (String) candiArray[0];
        String[] result = path.split(",");
        res.add(result[0]);
        res.add(result[1]);
        res.add(result[2]);
        return res;
    }
}
