import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        KnotsAndCrosses game = new KnotsAndCrosses();
        game.initializeBoard();
        System.out.println("Knots And Crosses!");
        do
        {
            System.out.println("Current board layout:");
            game.printTiles();
            int row;
            int col;
            do
            {
                System.out.println("Player " + game.getCurrentPlayerMove() + ", enter an empty row and column to place your move!");
                row = scan.nextInt()-1;
                col = scan.nextInt()-1;
            }
            while (!game.placeMove(row, col));
            game.changePlayer();
        }
        while(!game.isTilesFull() && !game.checkForWin());
        if (!game.checkForWin && game.isTilesFull())
        {
            System.out.println("The game was a draw!");
        }
        else
        {
            System.out.println("Current board layout:");
            game.printTiles();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMove()) + " Wins!");
        }
    }
}
