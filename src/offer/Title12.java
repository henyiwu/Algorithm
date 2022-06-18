package offer;

public class Title12 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length ||
                i < 0 ||
                j >= board[0].length ||
                j < 0 ||
                board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) return true;

        board[i][j] = '*'; // 遍历过的位置随便用*表示，表示遍历过这个位，下次再进来肯定返回false

        // 二维数组从上下左右四个方向开始深度遍历，k+1表示查找字符串的下一个字符
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = word[k]; // 把上面用*替代的位置恢复

        return res;
    }
}
