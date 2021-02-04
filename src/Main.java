import fr.charlier.puissance4game.controller.GameController;
import fr.charlier.puissance4game.games.GameBoard;


public class Main {

    public static void main(String[] args) {
        GameBoard gameModel = new GameBoard();

        GameController gameControler = new GameController(gameModel);

        gameControler.displayView();

    }
}
