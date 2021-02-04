package fr.charlier.puissance4game.games;

import java.util.EventListener;

public interface GameListener extends EventListener {

    public void colorChanged(GameChangedEvent event);
    public void pointChanged(GameChangedEvent event);
    public void playerChanged(GameChangedEvent event);
    public void winnerFounded(GameChangedEvent event);
    public void restartInvoked(GameChangedEvent event);
}
