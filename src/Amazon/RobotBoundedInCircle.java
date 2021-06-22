package Amazon;

/**
 * LC 1041. https://leetcode-cn.com/problems/robot-bounded-in-circle/
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        char[] instrs = instructions.toCharArray();
        int len = instrs.length;
        if (len <= 0) return true;

        // in clockwise order
        int[][] directs = {
                {0, 1},  // North
                {1, 0},  // East
                {0, -1}, // South
                {-1, 0}  // West
        };
        // initial direction vector, initial position
        int[] vec = {0, 1}, pos = {0, 0};
        int directIdx = 0;

        for (int i = 0; i < len; i++) {
            switch (instrs[i]) {
                case 'G':
                    incrementVec(pos, vec);
                    break;
                case 'L':
                    directIdx = (directIdx - 1 + 4) % 4;
                    vec[0] = directs[directIdx][0];
                    vec[1] = directs[directIdx][1];
                    break;
                case 'R':
                    directIdx = (directIdx + 1) % 4;
                    vec[0] = directs[directIdx][0];
                    vec[1] = directs[directIdx][1];
                    break;
            }
        }
        if (pos[0] == 0 && pos[1] == 0) return true;
        if (vec[0] != directs[0][0] || vec[1] != directs[0][1]) return true;
        return false;
    }

    public static void incrementVec(int[] A, int[] B) {
        if (A.length != 2 || B.length != 2) return;
        A[0] += B[0];
        A[1] += B[1];
    }

    public static void main(String[] args) {
//        int[] A = {1, 2}, B = {3, 4};
//        incrementVec(A, B);
//        System.out.printf("(%d, %d)", A[0], A[1]);
        int i = -1;
        System.out.println(i % 4);
    }
}
