package fr.charlier.puissance4game.controller;

import fr.charlier.puissance4game.games.GameListener;

public abstract class GameView implements GameListener {

    private GameController controller = null;

    public GameView(GameController controller  ){
        super();
        this.controller = controller;
    }

    public final GameController getController(){
        return controller;
    }

    public abstract void display();

    public abstract void close();

   // public abstract void changeVue();

    public abstract void displayWinner();

    public abstract void mouseListenerActivated();

}
