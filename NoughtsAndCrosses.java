public class NoughtsAndCrosses {

    private char[][] tiles;
    private char currentPlayerMove;

    public NoughtsAndCrosses() {
        tiles = new char[3][3];
        currentPlayerMove = 'x';
        initializeTiles();
    }

    //Gives access to currentPlayerMove
    public char getCurrentPlayerMove()
    {
        return currentPlayerMove;
    }


    // Set the tiles back to all empty values.
    public void initializeTiles() {

        // Loop through rows
        for (int i = 0; i < 3; i++) {

            // Loop through columns
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = '-';
            }
        }
    }


    // Print current tiles
    public void printTiles() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tiles[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    // Loop through cells of the tiles and if one is found to cointain "-" then return false.
    public boolean isTilesFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }


    // Returns true if there is a win, false otherwise.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }


    // Loops through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(tiles[i][0], tiles[i][1], tiles[i][2]) == true) {
                return true;
            }
        }
        return false;
    }


    // Loops through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(tiles[0][i], tiles[1][i], tiles[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


    // Check the two diagonals to see if either is a win, returns true if so.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(tiles[0][0], tiles[1][1], tiles[2][2]) == true) || (checkRowCol(tiles[0][2], tiles[1][1], tiles[2][0]) == true));
    }


    // Check to see if all three values are the same (and not containing "-") indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }


    // Change player moves back and forth.
    public void changePlayer() {
        if (currentPlayerMove == 'x') {
            currentPlayerMove = 'o';
        }
        else {
            currentPlayerMove = 'x';
        }
    }

    // Places a move at the cell specified by row and col with the move of the current player.
    public boolean placeMove(int row, int col) {

        // Make sure that row and column are in bounds of the tiles.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (tiles[row][col] == '-') {
                    tiles[row][col] = currentPlayerMove;
                    return true;
                }
            }
        }

        return false;
    }
}
