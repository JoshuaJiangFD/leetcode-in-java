package joshua.leetcode.design;

/**
 * 348. Design Tic-Tac-Toe <br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/design-tic-tac-toe/">leetcode link</a>
 * <p/>
 * Created by joshu on 2016/5/26.
 */
public abstract class TicTacToe {

    /**
     * Initialize your data structure here.
     *
     * @param n the length of column and row.
     */
    public TicTacToe(int n) {
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public abstract int move(int row, int col, int player);

    public static class Solution1 extends TicTacToe {

        int[] rows;
        int[] columns;
        int n;
        int diagonal;
        int antiDiagonal;

        public Solution1(int n) {
            super(n);
            rows = new int[n];
            columns = new int[n];
            this.n = n;
        }

        /**
         * X 表示 play 1. player 1赢棋。
         * |X| |O|
         * |O|O| |
         * |X|X|X|
         *
         * 如果用 col[3]和row[3]表示每个点在两个轴的投影，可以得出结论最后一行全是X，所以row[2] == 3。
         * 因此可以用两个数组记录每次下棋在两个轴上的投影，X表示-1, O表示1.任意一个轴上某个位置的值等于3或者-3
         * 就表示当前棋手赢了。
         * 另外需要两个变量保存对角线和斜对角线上的值得累加。
         *
         */
        @Override
        public int move(int row, int col, int player) {
            int val = player == 1 ? 1 : -1;
            rows[row] += val;
            if (rows[row] == n * val) return player;
            columns[col] += val;
            if (columns[col] == n * val) return player;
            if (row == col) {
                diagonal += val;
                if (diagonal == n * val) return player;
            }
            if (row + col == n - 1) {
                antiDiagonal += val;
                if (antiDiagonal == n * val) return player;
            }
            return 0;
        }
    }
}
