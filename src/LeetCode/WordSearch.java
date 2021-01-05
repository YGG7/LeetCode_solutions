package LeetCode;

import java.util.Arrays;

/**
 * Jianzhi 12. https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] wd = word.toCharArray();
        int numRows = board.length, numColumns = board[0].length;
        boolean[][] visited = new boolean[numRows][numColumns];
        // since every unsuccessful search will reset visited
        // need not reset visited manually in every loop
        for (boolean[] line:visited) {
            Arrays.fill(line, false);
        }

        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numColumns; j++) {
                if(dfs(board, wd, visited, i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] pattern, boolean[][] visited, int x, int y, int k) {
        // exclude out-of-bound, repeated visit, unsuccessful match
        if(!isInArea(board, x, y) || visited[x][y] || board[x][y]!=pattern[k]) return false;
        // search successful, return and terminate
        if(k==pattern.length-1) return true;

        visited[x][y] = true;
        boolean up = dfs(board, pattern, visited, x-1, y, k+1);
        boolean down = dfs(board, pattern, visited, x+1, y, k+1);
        boolean left = dfs(board, pattern, visited, x, y-1, k+1);
        boolean right = dfs(board, pattern, visited, x, y+1, k+1);
        if (up || down || left || right) return true;
        else {
            // if search is unsuccessful, reset visit mark
            visited[x][y] = false;
            return false;
        }
    }

    private boolean isInArea(char[][] board, int x, int y) {
        return x>=0&&x<board.length&&y>=0&&y<board[0].length;
    }

    public static void main(String[] args) {
        char[][] b = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String wd = "ABCESEEEFS";
        WordSearch ws = new WordSearch();
        if(ws.exist(b,wd)) System.out.println("TRUE");
        else System.out.println("FALSE");
    }
}
