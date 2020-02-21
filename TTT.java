public class TTT {

    private char[][] board;
    private char currentPlayerMark;

    public TTT() {
        board = new char[5][5];
        currentPlayerMark = 'x';
        initializeBoard();
    }

    public char getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }


    public void initializeBoard() {
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                board[i][j] = '-';
            }
        }
    }


    public void printBoard() {
        System.out.println("---------------------");

        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }
    }


    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }


    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }


    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (
                (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) || 
                (checkRowCol(board[i][1], board[i][2], board[i][3]) == true) || 
                (checkRowCol(board[i][2], board[i][3], board[i][4]) == true)
            ) {
                return true;
            }
        }
        return false;
    }


    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (
                (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) || 
                (checkRowCol(board[1][i], board[2][i], board[3][i]) == true) || 
                (checkRowCol(board[2][i], board[3][i], board[4][i]) == true)
            ) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDiagonalsForWin() {
        for (int i = 0; i < 3; i++) {
            if (
                (checkRowCol(board[2][0], board[3][1], board[4][2]) == true) || 
                (checkRowCol(board[1][0], board[2][1], board[3][2]) == true) ||
                (checkRowCol(board[2][1], board[3][2], board[4][3]) == true) ||
                (checkRowCol(board[0][0], board[1][1], board[2][2]) == true) ||
                (checkRowCol(board[1][1], board[2][2], board[3][3]) == true) ||
                (checkRowCol(board[2][2], board[3][3], board[4][4]) == true) ||
                (checkRowCol(board[0][1], board[1][2], board[2][3]) == true) ||
                (checkRowCol(board[0][2], board[1][3], board[2][4]) == true) ||
                // opposite
                (checkRowCol(board[2][4], board[3][3], board[4][2]) == true) ||
                (checkRowCol(board[1][4], board[2][3], board[3][2]) == true) ||
                (checkRowCol(board[2][3], board[3][2], board[4][1]) == true) ||
                (checkRowCol(board[0][4], board[1][3], board[2][2]) == true) ||
                (checkRowCol(board[1][3], board[2][2], board[3][1]) == true) ||
                (checkRowCol(board[2][2], board[3][1], board[4][0]) == true) ||
                (checkRowCol(board[0][3], board[1][2], board[2][1]) == true) ||
                (checkRowCol(board[1][2], board[2][1], board[3][0]) == true) ||
                (checkRowCol(board[0][2], board[1][1], board[2][0]) == true)
            ) {
                return true;
            }
        }
        return false;
    }


    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }


    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int col) {

        if ((row >= 0) && (row < 5)) {
            if ((col >= 0) && (col < 5)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }
}