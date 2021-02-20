package fr.charlier.puissance4game.games;

import fr.charlier.puissance4game.model.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class IAPlayer {

    int columnNumber = 0;
    int rowNumber = 0;
    Point newPoint = new Point();
    Point point = new Point();
    private ArrayList<Board> arrayBoard;


    public IAPlayer() {

    }

    public Point selectedCoordonnate(ArrayList<Board> board) {
        this.arrayBoard = board;
        ArrayList<Board> arrayResult = new ArrayList<>();

       /* for (Board elem : arrayBoard) {
            System.out.println(elem);
        }*/

        arrayResult.add(findRowWithMaxToken());
        arrayResult.add(findColumnWithMaxToken());
        for (Board elem : arrayResult) {
            System.out.println(elem);
        }

        Board choicePosition = arrayResult.stream().max(Comparator.comparing(Board::getTokenMax)).orElseThrow(NoSuchElementException::new);
        newPoint = choicePosition.getPoint();
        //  System.out.println("le Nb de token max est :"+ choicePosition.getTokenMax());

        if (choicePosition.getTokenMax() < 2) {
            newPoint.x = (int) (Math.random() * (770 - 0));
            newPoint.y = (int) (Math.random() * (660 - 0));
        }
        return newPoint;
    }


    public Board findColumnWithMaxToken() {
        int totalOfColumn = 0;
        int valueMaxColumn = 0;
        Point pColumn = new Point();
        //  int columnWithMaxToken = 0;

        for (columnNumber = 0; columnNumber < 7; columnNumber++) {

            //Optional to find if line with token exist
            Optional<Board> answer = arrayBoard.stream().filter(s -> s.getColumn() == columnNumber && s.getValueOfToken() != 0).findFirst();

            // if Optionnal is true , calculate the total of token inside the column
            if (answer.isPresent() && answer.get().getValueOfToken() == 1) {
                totalOfColumn = arrayBoard.stream()
                        .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                        .limit(3)
                        .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);


                if (totalOfColumn < 3) {
                    totalOfColumn = arrayBoard.stream()
                            .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                            .limit(2)
                            .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);
                }
            }

            if (totalOfColumn > valueMaxColumn) {
                valueMaxColumn = totalOfColumn;
                pColumn.x = answer.get().getPosXFinale();
                pColumn.y = answer.get().getPosYFinale() - 110;
            }

        }

        return new Board("Column", pColumn, valueMaxColumn);

    }

    public Board findRowWithMaxToken() {
      //  System.out.println(" findrowWithMaxToken called + rowNumber is : " + rowNumber);
        Point pRow = new Point();
        int valueMaxRow = 0;
        int maxRowTokens = 0;
        pRow.x = 0;
        pRow.y = 0;
        int resultLFT = -1;
        int resultRFT = -1;
        int totalRow2Tokens = 0;
        int totalRow3Tokens = 0;
      //  int toto = 0;
        // int columnNb = 0;

        // debut modif

        /** check total of row is 3*/
        for (rowNumber = 5; rowNumber >= 0; rowNumber--) {

            //Optional to find if line with token exist
            Optional<Board> answer = arrayBoard.stream().filter(s -> s.getRow() == rowNumber && s.getValueOfToken() != 0).findFirst();
         //   System.out.println(" answer est :" + answer);
            if (answer.isPresent()) {
          //      System.out.println("if answer is present la ligne est rowNumber = " + rowNumber + " answer.get().getRow is = " + answer.get().getRow());

                for (columnNumber = 0; columnNumber < 5; columnNumber++) {

                    totalRow3Tokens = arrayBoard.stream()
                            .filter(c -> c.getRow() == rowNumber)
                            .skip(columnNumber)
                            .peek(s -> {
                                System.out.println("rowNumber is  = " + s.getRow() + " ; columnNumber" + s.getColumn());
                            })
                            .limit(3)
                            .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);
         //           System.out.println("la valeur de totalRow3tokens est à la sortie du stream : " + totalRow3Tokens);

                    if (totalRow3Tokens == 3) {

                        if (columnNumber > 0) {
                            resultLFT = leftFreeToken(rowNumber, columnNumber);
        //                    System.out.println("resultLFT is = " + resultLFT);
                        }

                        if (columnNumber < 3) {
                            resultRFT = rightFreeToken(rowNumber, columnNumber, 3);
         //                   System.out.println("resultRFT is = " + resultRFT);
                        }

                        if (resultLFT != -1) {
                            pRow.x = arrayBoard.get(resultLFT).getPosXFinale();
                            pRow.y = arrayBoard.get(resultLFT).getPosYFinale();
                        }
                        if (resultRFT != -1) {
                            pRow.x = arrayBoard.get(resultRFT).getPosXFinale();
                            pRow.y = arrayBoard.get(resultRFT).getPosYFinale();
                        }

                        if (resultLFT != -1 || resultRFT != -1) {
             //               System.out.println("je rentre dans la derniere egalite des 3 tokens et totalRow3 Tokens est : " + totalRow3Tokens);
                            valueMaxRow = totalRow3Tokens;
                            break;
                        }

                    }

                }


            }
            if (valueMaxRow == 3) {
                break;
            }
        }

        if (valueMaxRow < 3) {
            valueMaxRow = 0;

            for (rowNumber = 5; rowNumber >= 0; rowNumber--) {

                //Optional to find if line with token exist
                Optional<Board> answer1 = arrayBoard.stream().filter(s -> s.getRow() == rowNumber && s.getValueOfToken() != 0).findFirst();

                if (answer1.isPresent()) {
                    //    System.out.println("la ligne est = " + rowNumber);

                    for (columnNumber = 0; columnNumber < 6; columnNumber++) {

                        totalRow2Tokens = arrayBoard.stream()
                                .filter(c -> c.getRow() == rowNumber)
                                .skip(columnNumber)
                                .limit(2)
                                .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);


                        if (totalRow2Tokens == 2) {


                            if (columnNumber > 0) {
                                resultLFT = leftFreeToken(rowNumber, columnNumber);
                //                System.out.println("resultLFT is = " + resultLFT);
                            }

                            if (columnNumber < 4) {
                                resultRFT = rightFreeToken(rowNumber, columnNumber, 2);
                 //               System.out.println("resultRFT is = " + resultRFT);
                            }

                            if (resultLFT != -1) {
                                pRow.x = arrayBoard.get(resultLFT).getPosXFinale();
                                pRow.y = arrayBoard.get(resultLFT).getPosYFinale();
                            }
                            if (resultRFT != -1) {
                                pRow.x = arrayBoard.get(resultRFT).getPosXFinale();
                                pRow.y = arrayBoard.get(resultRFT).getPosYFinale();
                            }

                            if (resultLFT != -1 || resultRFT != -1) {
                 //               System.out.println("je rentre dans la derniere egalite des 2 tokens et totalRow3 Tokens est : " + totalRow2Tokens);
                                valueMaxRow = totalRow2Tokens;
                                break;
                            }

                        }
                    }
                }
                if (valueMaxRow == 2) {
                    break;
                }
            }

        }


     //   System.out.println("la valeur max row finale est : " + valueMaxRow);
        // fin modif
        return new Board("Row", pRow, valueMaxRow);


    }


    public Boolean downFreeToken(int index) {

        // déterminer si le jeton sous le jeton selectionné à gauche est vide

        int getRow = arrayBoard.get(index).getRow();
        int getColumn = arrayBoard.get(index).getRow();

        // if (index)
        if (arrayBoard.get(index).getRow() == 5 && arrayBoard.get(index).getValueOfToken() >= 0) {
            return true;
        }

      /*  if (arrayBoard.get(index).getRow() == 5){
            return true;
        }
        else if ( arrayBoard.get(index).getPosYFinale()<= 550  && arrayBoard.get(index).getPosXFinale()>=0 && arrayBoard.get(index+1).getValueOfToken() !=0  ) {
            return true;
        }
        else return false;*/
        return true;
    }

    public int leftFreeToken(int rowNb, int columnNb) {
        int currentIndex = ((columnNb * 6) + rowNb);
        //    int beforeFirstTokenIndex = 0;
     //   System.out.println("currentIndex is = " + currentIndex);
        if (arrayBoard.get(currentIndex - 6).getValueOfToken() == 0) {

            if (rowNb < 5 && arrayBoard.get(currentIndex - 5).getValueOfToken() != 0) {
                return currentIndex - 6;

            } else if (rowNb == 5) {
                return currentIndex - 6;
            } else return -1;
        } else {
            return -1;
        }

    }

    public int rightFreeToken(int rowNb, int columnNb, int calculOfNbToken) {

        int currentIndex = (((columnNb) * 6) + rowNb);
        //    int beforeFirstTokenIndex = 0;
        if (arrayBoard.get(currentIndex + (calculOfNbToken * 6)).getValueOfToken() == 0) {

            if (rowNb < 5 && arrayBoard.get(currentIndex + (calculOfNbToken * 6 + 1)).getValueOfToken() != 0) {
                return currentIndex + (calculOfNbToken * 6);

            } else if (rowNb == 5) {

                return currentIndex + (calculOfNbToken * 6);

            } else return -1;
        } else {
            return -1;
        }


    }
}

 /* int currentIndex = (((columnNumber) * 6) + rowNumber);
                            // System.out.println("currentindex for 2 token : "+currentIndex + " ce qui donne : pour coordonnées : "+arrayBoard.get(currentIndex).getPosXFinale() +" "+ arrayBoard.get(currentIndex).getPosYFinale());
                            int beforeFirstToken = (((columnNumber - 1) * 6) + rowNumber);
                            int afterSecondToken = (((columnNumber + 2) * 6) + rowNumber);

                            if ((columnNumber + 2) < 7 && arrayBoard.get(afterSecondToken).getValueOfToken() == 0) {
                                valueMaxRow = totalRow2Tokens;
                                pRow.x = arrayBoard.get(afterSecondToken).getPosXFinale();
                                pRow.y = arrayBoard.get(afterSecondToken).getPosYFinale();
                                columnNumber = 7;
                                rowNumber = -1;

                            } else if ((columnNumber - 1) >= 0 && arrayBoard.get(beforeFirstToken).getValueOfToken() == 0) {
                                valueMaxRow = totalRow2Tokens;
                                pRow.x = arrayBoard.get(beforeFirstToken).getPosXFinale();
                                pRow.y = arrayBoard.get(beforeFirstToken).getPosYFinale();
                                columnNumber = 7;
                                rowNumber = -1;

                            }*/
//   int currentIndex = (((columnNb) * 6) + rowNumber);
//   System.out.println("currentindex for 3 token : "+currentIndex);
//   int beforeFirstTokenIndex =  currentIndex - 6;     //(((columnNb - 1) * 6) + rowNumber);
//    int afterThirdTokenIndex = currentIndex + (6*3);   //(((columnNb + 3) * 6) + rowNumber);

                       /* boolean dFTBFT = downFreeToken(beforeFirstTokenIndex);
                        boolean dFTATT = downFreeToken(afterThirdTokenIndex);*/
                       /* int downAfterThirdToken =  0;
                        int downBeforeFirstToken =0;*/

                       /* if ((columnNb + 3) < 7 && arrayBoard.get(afterThirdTokenIndex).getValueOfToken() == 0 && dFTATT) {
                            pRow.x = arrayBoard.get(afterThirdTokenIndex).getPosXFinale();
                            pRow.y = arrayBoard.get(afterThirdTokenIndex).getPosYFinale();


                        } else if ((columnNb - 1) >= 0 && arrayBoard.get(beforeFirstTokenIndex).getValueOfToken() == 0 && dFTBFT) {
                            pRow.x = arrayBoard.get(beforeFirstTokenIndex).getPosXFinale();
                            pRow.y = arrayBoard.get(beforeFirstTokenIndex).getPosYFinale();
                        }*/
  /*

   int rowNumber = findRowNumber();
        int totalRow = 0;

        for (int i = 0; i < 6; i++) {
            totalRow = boardArray.stream()
                    .filter(c -> c.getRow() == rowNumber)
                    .skip(i)
                    .limit(2)
                    .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);

            if (Math.abs(totalRow) == 2) {
                return totalRow;
            }
        }
        return totalRow;
    }*/


//  int columnnValue = findColumnWithMaxToken();

       /* int totalOfColumn = 0;
        int valueMax = 1;
        int columnWithMaxToken = 0;

        for (columnNumber = 0; columnNumber < 7; columnNumber++) {

            //Optional to find if line with token exist
            Optional<Board> answer = board.stream().filter(s -> s.getColumn() == columnNumber && s.getValueOfToken() != 0).findFirst();

            // if Optionnal is true , calculate the total of token inside the column
            if (answer.isPresent() && answer.get().getValueOfToken() == 1) {
                totalOfColumn = board.stream()
                        .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                        .limit(2)
                        .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);
            }

            if (totalOfColumn > valueMax) {
                valueMax = totalOfColumn;
                newPoint.x = answer.get().getPosXFinale();
                newPoint.y = answer.get().getPosYFinale();
            }

        }*/
// System.out.println("la colonne n° = " + columnWithMaxToken + " a le plus de jetons jaune soit = " + valueMax);

//   int toto=  board.stream().filter(c -> c.getColumn() == 0 && c.getColor() == null).reduce((first, second) -> second).get();


//  Board toto =  board.stream().filter(c -> c.getColumn() == 0 && c.getColor() != null).reduce((first, second) -> second).get();
//System.out.println(" la ligne libre de la colonne 0 est = "+toto.getRow()+ toto.getColor());


          /* newPoint.x= firstBoard.getPosXFinale();
                    newPoint.y = firstBoard.getPosYFinale();*/
   /*     column = board.stream()
                        .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                        .limit(2)
                        .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);


                System.out.println(" la colonne n° "+firstBoard.getColumn()+"est de couleur"+firstBoard.getColor()+" et a "+totalColumn+" jetons qui se suivent");*/

//  if (firstBoard.getValueOfToken() == 1) {

//  System.out.println(" la colonne n° "+firstBoard.getColumn()+"est de couleur"+firstBoard.getColor()+" et a "+totalColumn+" jetons qui se suivent");
//  }

// Board firstBoard = board.stream().filter(s -> s.getColumn()==columnNumber && s.getValueOfToken() !=0).findFirst().get();
//  Board firstBoard = board.stream().filter(s -> s.getColumn() == columnNumber  && s.getValueOfToken() !=0 ).limit(1).reduce(null, (first, second) -> second);



       /* for (columnNumber = 0; columnNumber < 7; columnNumber++) {

            Board firstBoard = board.stream().filter(s -> s.getColumn() == columnNumber ).limit(6).reduce(null, (first, second) -> second);
            if (firstBoard.getColor() == Constante.TOKEN_COLOR_PLAYER1) {
                totalColumn = board.stream()
                        .filter(c -> c.getColumn() == columnNumber && c.getValueOfToken() != 0)
                        .limit(4)
                        .reduce(0, (somme, e) -> somme += e.getValueOfToken(), (somme1, somme2) -> somme1 + somme2);


                  System.out.println(" la colonne n° "+firstBoard.getColumn()+"est de couleur"+firstBoard.getColor()+" et a "+totalColumn+" jetons qui se suivent");
           }


            if (totalColumn > valueMax) {
                valueMax = totalColumn;
                colmunNumberMax = firstBoard.getColumn();
                if (valueMax >=2){
                    newPoint.x= firstBoard.getPosXFinale();
                    newPoint.y = firstBoard.getPosYFinale();
                    System.out.println(newPoint);
                }
                else{
                    newPoint.x  =(int)(Math.random()*(770 - 0));
                    newPoint.y = (int)(Math.random()*(660 -0));
                }

                System.out.println("la colonne n° = " + colmunNumberMax + " a le plus de jetons jaune soit = " + valueMax);
            }
*/