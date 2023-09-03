package Hard_Problems;

// 37. Sudoku Solver

/*Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all the following rules:

    1. Each of the digits 1-9 must occur exactly once in each row.
    2. Each of the digits 1-9 must occur exactly once in each column.
    3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' The Character indicates empty cells.*/
public class SudokuSolver_37 {
    public static void printBoard(char[][] board) {  // Extra Method for printing Board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SolutionSudokuSolver solutionSudokuSolver
                = new SolutionSudokuSolver();
        solutionSudokuSolver.solveSudoku(board);

        printBoard(board);
    }
}

class SolutionSudokuSolver {
    public boolean isSafe(char[][] board, int rows, int columns, int number) {
        // for Rows & Columns
        for (int i = 0; i < board.length; i++) {
            if (board[i][columns] == (char) (number + '0')) {
                return false;
            }
            if (board[rows][i] == (char) (number + '0')) {
                return false;
            }
        }

        // for Grid
        int startingRows = (rows / 3) * 3;
        int startingColumns = (columns / 3) * 3;

        for (int i = startingRows; i < startingRows + 3; i++) {
            for (int j = startingColumns; j < startingColumns + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int rows, int columns) {
        if (rows == board.length) {
            return true;
        }

        int newColumns, newRows;

        if (columns != board.length - 1) {
            newRows = rows;
            newColumns = columns + 1;
        } else {
            newRows = rows + 1;
            newColumns = 0;
        }

        if (board[rows][columns] != '.') {
            return helper(board, newRows, newColumns);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, rows, columns, i)) {
                    board[rows][columns] = (char) (i + '0');
                    if (helper(board, newRows, newColumns)) {
                        return true;
                    } else {
                        board[rows][columns] = '.';
                    }
                }
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}

/*Expected Output::

Example 1:

5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9


OR,

Input: board = [["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]]

Output:         [["5","3","4","6","7","8","9","1","2"],
                 ["6","7","2","1","9","5","3","4","8"],
                 ["1","9","8","3","4","2","5","6","7"],
                 ["8","5","9","7","6","1","4","2","3"],
                 ["4","2","6","8","5","3","7","9","1"],
                 ["7","1","3","9","2","4","8","5","6"],
                 ["9","6","1","5","3","7","2","8","4"],
                 ["2","8","7","4","1","9","6","3","5"],
                 ["3","4","5","2","8","6","1","7","9"]]

Explanation: The input board is shown above and the only valid solution is shown below:

* */
