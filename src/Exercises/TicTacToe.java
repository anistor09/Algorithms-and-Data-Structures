public class TicTacToe {
    int[][] board;

    public TicTacToe(int n) {

        board = new int[n][n];

    }

    public int move(int row, int col, int player) {

        board[row][col] = player;

        boolean diagonal = true;
        boolean column = true;
        boolean line = true;


        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player)
                column = false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player)
                line = false;
        }

        if (col == row) {

            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != player)
                    diagonal = false;
            }
        } else if (col == board.length - row - 1) {

            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - i - 1] != player)
                    diagonal = false;

            }
        } else {
            diagonal = false;
        }

        if (diagonal || line || column) {
            return player;
        }
        return 0;

    }
}


