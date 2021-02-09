package fr.charlier.puissance4game.controller;

import fr.charlier.puissance4game.games.GameBoard;
import fr.charlier.puissance4game.view.MainFrame;
import javax.swing.*;
import java.awt.*;

public class GameController {

    public GameView mainFrameView = null;
    public GameBoard model = null;


    public GameController(GameBoard model) {
        this.model = model;
        mainFrameView = new MainFrame(this);
        addListenerToModel();
    }

    private void addListenerToModel() {
        model.addGameListener(mainFrameView);
    }

    public void displayView() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(" thread edt dans GameController displayView du run =" + SwingUtilities.isEventDispatchThread());
                mainFrameView.display();
            }
        });
        System.out.println(" thread edt dans GameController displayView =" + SwingUtilities.isEventDispatchThread());
    }


    public void closeView() {
        mainFrameView.close();
    }

    public void notifyGameStart() {
        model.start();
    }

    public void notifyPlayersSelected(String playerName1, String playerName2) {
        model.playersSelected(playerName1, playerName2);
    }

    public void notifyGameRestart() {
        model.reStart();
        model.changePlayer();
    }

    public void notifyAnimateTerminated() {
        if (model.checkIfWinner()) {
            model.fireWinnerFounded();
            mainFrameView.displayWinner();
        } else {
            model.changePlayer();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    mainFrameView.mouseListenerActivated();
                }
            });
        }
    }

    public void notifyPointChanged(Point point) {
        model.setPoint(point);
    }

    public void notifyPlayerChanged(String player) {
        model.setPlayer(player);
    }
}







