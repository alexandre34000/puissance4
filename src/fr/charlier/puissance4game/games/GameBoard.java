package fr.charlier.puissance4game.games;


import fr.charlier.puissance4game.controller.Constante;
import fr.charlier.puissance4game.model.Board;
import fr.charlier.puissance4game.model.Player;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard {

    private ArrayList<Board> boardArray = new ArrayList<>();
    private boolean isPlayer1 = true;
    private String player;
    private Player player1 = null;
    private Player player2 = null;
    private Point newPointStart = new Point();
    private Point newPointEnd = new Point();
    private EventListenerList listeners;
    private String playerName;
    private Color color;
    private Point point;
    private int columnsNumber = Constante.COLUMNS;
    private int linesNumber = Constante.ROWS;
    private int columnSize = Constante.JPANEL_FONT_WIDTH / Constante.COLUMNS;
    private int rowSize = Constante.JPANEL_ANIMATE_HEIGHT / Constante.COLUMNS;


    public GameBoard() {
        super();
        listeners = new EventListenerList();
        player1 = new Player("Player 1", Constante.TOKEN_COLOR_PLAYER1);
        player2 = new Player("Player 2", Constante.TOKEN_COLOR_PLAYER2);
    }

    public void playersSelected(){
        fireChangeScreen();
    }

    public void reStart() {
        clearArrayBoard();
        buildArrayBoard();
        this.isPlayer1 = true;
        setColor(new Color(0, 0, 0, 0));
        fireRestartInvoked();
    }

    public void start() {
        buildArrayBoard();
        changePlayer();
    }

    public ArrayList<Board> buildArrayBoard() {
        for (int i = 0; i < columnsNumber; i++) {
            for (int j = 0; j < linesNumber; j++) {
                boardArray.add(new Board(i, j, 0, 0, 0, 0, 0, null));
            }
        }
        return boardArray;
    }

    public ArrayList<Board> clearArrayBoard() {
        boardArray.clear();
        return boardArray;
    }

    /* find free space in the boardArray for accept new token and set values inside */
    public int fillBoard() {

        int columnNumber = findColumnNumber();

        Board last = null;
        try {
            last = boardArray.stream().filter(c -> c.getColumn() == columnNumber && c.getColor() == null).reduce((first, second) -> second).get();
        } catch (Exception e) {
            System.out.println(" tous sont à NULL");
        }
        if (last == null) {
            System.out.println("last in fillBoard is null");
            return 1;
        } else {
            newPointEnd = findEndPosition(last.getRow(), last.getColumn());
            last.setPosXFinale(newPointEnd.x);
            last.setPosYFinale(newPointEnd.y);
            if (isPlayer1) {
                setColor(player1.getColor());
            } else {
                setColor(player2.getColor());
            }
            last.setColor(getColor());
            if (getColor().equals(Constante.TOKEN_COLOR_PLAYER1)) {
                last.setValueOfToken(Constante.TOKEN_VALUE_PLAYER1);
            } else {
                last.setValueOfToken((Constante.TOKEN_VALUE_PLAYER2));
            }
            firePointsChanged();
            return 0;
        }
    }

    public boolean checkIfWinner() {
        int checkWinnerColumn = checkAlignementOfSameFourTokenColumn(findColumnNumber());
        int checkWinnerRow = checkAlignementOfSameFourTokenRow();
        int checkWinnerDiagonaleRToL = checkAlignementOfSameFourTokenDiagonalRightToLeft();
        int checkWinnerDiagonaleLToR = checkAlignementOfSameFourTokenDiagonalLeftToRight();

        if (Math.abs(checkWinnerColumn) == 4 || Math.abs(checkWinnerRow) == 4 ||
                Math.abs(checkWinnerDiagonaleRToL) == 4 || Math.abs(checkWinnerDiagonaleLToR) == 4) {

           winnerFounded();
            return true;
        } else {
             winnerNotfounded();
            return false;

        }
    }

    public void winnerFounded() {
        if (isPlayer1) {
            playerName = player1.getPlayerName();
        } else {
            playerName = player2.getPlayerName();
        }
     //   fireWinnerFounded();
    }

    public void winnerNotfounded() {
        this.isPlayer1 = !isPlayer1;
      //  changePlayer();
    }


    public int checkAlignementOfSameFourTokenColumn(int columnNumber) {

        int totalColumn = boardArray.stream()
                .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                .limit(4)
                .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);
        return totalColumn;
    }

    public int checkAlignementOfSameFourTokenRow() {

        int rowNumber = findRowNumber();
        int totalRow = 0;

        for (int i = 0; i < 4; i++) {
            totalRow = boardArray.stream()
                    .filter(c -> c.getRow() == rowNumber)
                    .skip(i)
                    .limit(4)
                    .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);

            if (Math.abs(totalRow) == 4) {
                return totalRow;
            }
        }
        return totalRow;
    }

    // check Alignement of same four Token diagonal right to left
    public int checkAlignementOfSameFourTokenDiagonalRightToLeft() {

        ArrayList<Board> diagonalRL = new ArrayList<>();
        int x = findPositionToken().x;
        int y = findPositionToken().y;
        for (int i = 0; i < 4; i++) {
            for (Board liste : boardArray) {
                if (liste.getColumn() == x && liste.getRow() == y) {
                    diagonalRL.add(boardArray.get(boardArray.indexOf(liste)));
                }
            }
            x--;
            y++;
        }
        return checkTotalOfDiagonal(diagonalRL);
    }

    // check Alignement of diagonal left to right
    public int checkAlignementOfSameFourTokenDiagonalLeftToRight() {

        ArrayList<Board> diagonalLR = new ArrayList<>();
        int x = findPositionToken().x;
        int y = findPositionToken().y;
        for (int i = 0; i < 4; i++) {
            for (Board liste : boardArray) {
                if (liste.getColumn() == x && liste.getRow() == y) {
                    diagonalLR.add(boardArray.get(boardArray.indexOf(liste)));
                }
            }
            x++;
            y++;
        }
        return checkTotalOfDiagonal(diagonalLR);
    }

    // Check total of diagonal
    public int checkTotalOfDiagonal(ArrayList<Board> list) {
        int totalDiagonal = list.stream()
                .filter(c -> c.getValueOfToken() != 0)
                .limit(4)
                .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);
        return totalDiagonal;
    }

    /*find the last element free in the column of Board*/
    public Board findLastElement() {
        return boardArray.stream().filter(c -> c.getColumn() == 0 && c.getColor() == null).reduce((first, second) -> second).get();
    }

    // return the number of column
    public int findColumnNumber() {
        int posX = (getPoint().x / columnSize);
        return posX;
    }

    // return the number of row
    public int findRowNumber() {
        int posY = getPoint().y / rowSize;
        return posY;
    }

    //return the number of the column and the row for check alignment of diagonal left-right and right-left
    public Point findPositionToken() {
        Point tokenPosition = new Point();
        tokenPosition.x = newPointEnd.x / Constante.TOKEN_WIDTH;
        tokenPosition.y = (newPointEnd.y / Constante.TOKEN_HEIGHT) - 1;
        return tokenPosition;
    }

    /*  return coordonnate of position start and set start position*/
    public Point findStartPosition() {//findStartPosition
        Point startPosition = new Point();
        int posYStart = 0;
        startPosition.x = findColumnNumber() * columnSize;
        startPosition.y = posYStart;
        return startPosition;
    }

    /* return coordonnate of position finish for row and column */
    public Point findEndPosition(int posYFinale, int posXFinale) {
        Point endPosition = new Point();
        endPosition.x = posXFinale;
        endPosition.y = (posYFinale * rowSize) + rowSize;
        return endPosition;
    }

    public int getNbTokenAlignedInsideColumn() {

        return 0;
    }

  /*  public void goAnimatePanel() {

        int speed = 10;

        for (int i = 0; i < newPointEnd.y / speed; i++) {
            newPointStart.y = i * speed;
            firePointsChanged();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    public void changePlayer() {

        Color colorTransparent =new Color(0, 0, 0, 0);

        if (isPlayer1) {
            player1.setColor(Constante.TOKEN_COLOR_PLAYER1);
            player2.setColor(colorTransparent);
        } else {
            player1.setColor(colorTransparent);
            player2.setColor(Constante.TOKEN_COLOR_PLAYER2);
        }
        firePlayerChanged();
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        newPointStart = findStartPosition();
        fillBoard();
    }

    public Point getNewPointStart() {
        return newPointStart;
    }

    public Point getNewPointEnd() {
        return newPointEnd;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        fireColorChanged();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void addGameListener(GameListener listener) {
        listeners.add(GameListener.class, listener);
    }

    public void removeGameListener(GameListener l) {
        listeners.remove(GameListener.class, l);
    }

    public void fireColorChanged() {
        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {
            listener.colorChanged(new GameChangedEvent(this, getColor()));

        }
    }

    public void firePointsChanged() {
        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {

            listener.pointChanged(new GameChangedEvent(this, getNewPointStart(), getNewPointEnd()));

        }
    }

    public void firePlayerChanged() {

        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {
            listener.playerChanged(new GameChangedEvent(this, player1.getColor(), player2.getColor()));
        }
    }

    public void fireWinnerFounded() {
        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {

            listener.winnerFounded(new GameChangedEvent(this, getPlayerName(), getColor()));
        }
    }

    public void fireRestartInvoked() {
        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {

            listener.restartInvoked(new GameChangedEvent(this));
        }
    }

    public void fireChangeScreen(){
        GameListener[] listenerList = listeners.getListeners(GameListener.class);

        for (GameListener listener : listenerList) {

            listener.changeScreen(new GameChangedEvent(this));
        }
    }



}
