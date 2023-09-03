package Hard_Problems;

import java.util.ArrayList;
import java.util.List;

// 51. N-Queens

/*The n-queens puzzle is the problem of placing n queens on an n x n
chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' Both indicate a queen and an empty space, respectively.*/

public class N_Queens_51 {
    public static void main(String[] args) {
        SolutionN_Queens_51 solutionNQueens51
                = new SolutionN_Queens_51();
        int n = 4;
        System.out.println(solutionNQueens51.solveNQueens(n));
    }
}

class SolutionN_Queens_51 {
    public boolean isSafe(int rows, int columns, char[][] board) {
        // Check Horizontal Directions
        for (int j = 0; j < board.length; j++) {
            if (board[rows][j] == 'Q') {
                return false;
            }
        }

        // Check Vertical Directions
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][columns] == 'Q') {
                return false;
            }
        }

        // Check Upper Left Directions
        int r = rows;

        for (int cUP = columns; r >= 0 && cUP >= 0; r--, cUP--) {
            if (board[r][cUP] == 'Q') {      // cUP = Columns of Upper-Left Directions
                return false;
            }
        }

        // Check Upper Right Directions
        r = rows;
        for (int cUR = columns; cUR < board.length && r >= 0; r--, cUR++) {
            if (board[r][cUR] == 'Q') {   // cUR = Columns of Upper Right Directions
                return false;
            }
        }

        // Check Lower Left Directions
        r = rows;
        for (int cLL = columns; cLL >= 0 && r < board.length; r++, cLL--) {
            if (board[r][cLL] == 'Q') {   // cLL = Columns of Lower Left Directions
                return false;
            }
        }

        // Check Lower Right Directions
//        r = rows;
        for (int cLR = columns; cLR < board.length && r < board.length; cLR++, r++) {
            if (board[r][cLR] == 'Q') {   // cLR = Columns of Lower Right Directions
                return false;
            }
        }
        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        StringBuilder rows = new StringBuilder();
        List<String> newBoard = new ArrayList<>();

        for (char[] chars : board) {
            rows = new StringBuilder();

            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == 'Q')
                    rows.append('Q');
                else
                    rows.append('.');
            }
            newBoard.add(rows.toString());
        }
        allBoards.add(newBoard);
    }

    public void
    helper(char[][] board, List<List<String>> allBoards, int columns) {
        if (columns == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int rows = 0; rows < board.length; rows++) {
            if (isSafe(rows, columns, board)) {
                board[rows][columns] = 'Q';
                helper(board, allBoards, columns + 1);
                board[rows][columns] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allBoards, 0);

        return allBoards;
    }
}

/*Expected Output::
Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

* */