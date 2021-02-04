package fr.charlier.puissance4game.model;

import fr.charlier.puissance4game.controller.Constante;

import java.awt.*;

public class Hand {



    private Color tokenColor = null;
    private int nbTokens = Constante.NB_TOKEN/2;
    private Tokens token;

    public Hand(Color color){
        this.tokenColor = color;
        token = new Tokens(color);

    }


    public Color getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(Color tokenColor) {
        this.tokenColor = tokenColor;
    }

    public int getNbTokens() {
        return nbTokens;
    }

    public void setNbTokens(int nbTokens) {
        this.nbTokens = nbTokens;
    }

  /*  public String getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(String tokenColor) {
        this.tokenColor = tokenColor;
    }*/
/*
    public ArrayList<String> BuildToken() {
        ArrayList token = new ArrayList();
        int i = 0;
        for (i = 0; i < (Constante.NB_TOKEN) / 2; i++) {
            token.add(tokenColor);
        }
        return token;
    }*/

}
  /*public Player(){
        this.playerName = playerName;
        token = new Tokens(TokenColor);
    }*/





/*public ArrayList addToken(Player p, Tokens t){

 *//* this.playerName = playerName;
        this.tokenColor = tokenColor;*//*

        List<String>tokenList = new ArrayList<>();
        for ( int i = 0; i < Constante.NB_TOKEN/2; i++ ) {
            tokenList.add(tokenColor);
        }
        return tokenList;

    }*/

    /*    player=token.BuildList();

        for ( String s: player){
            System.out.println("name : "+playerName+" jeton de couleur : "+s);
        }
        return player.size();*/


/*

    public int RemoveOne(){
        player.remove(1);
        return player.size();
    }


*/