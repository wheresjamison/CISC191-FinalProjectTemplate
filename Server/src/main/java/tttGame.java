public class tttGame {
    //this is the TicTacToe Board

    String[][] board = {{" "," ", " "},
            {" "," ", " "},
            {" "," ", " "}};

    //prints the gameBoard and puts it onto the buttons
    //dont need this anymmore since the interface
    static char[][] printBoard(char[][] boardIn){
        for(int a=0; a<3; a++){
            for(int b=0; b<3; b++){
                System.out.print("| " + boardIn[a][b] + " | ");
            }
            System.out.println();
        }
        return boardIn;
    }

    //converts number 1-9 to returns an index of grid
    static int[] convertPos(int x) {
        int a = 0;
        int b = 0;
        switch (x) {
            case 1:
                a = 0;
                b = 0;
                break;
            case 2:
                a = 0;
                b = 1;
                break;
            case 3:
                a = 0;
                b = 2;
                break;
            case 4:
                a = 1;
                b = 0;
                break;
            case 5:
                a = 1;
                b = 1;
                break;
            case 6:
                a = 1;
                b = 2;
                break;
            case 7:
                a = 2;
                b = 0;
                break;
            case 8:
                a = 2;
                b = 1;
                break;
            case 9:
                a = 2;
                b = 2;
                break;
        }
        int[] indexFromArray = new int[2];
        indexFromArray[0] = a;
        indexFromArray[1] = b;
        return indexFromArray;
    }

    //changes the turns, returns current turn
    static char nextTurn(String getTurn){
        //converts the string to char
        char returnTurn = getTurn.charAt(0);
        //changes the turn
        if(returnTurn == 'o'){
            returnTurn = 'x';
        }
        if(returnTurn == 'x') {
            returnTurn = 'o';
        }
        //returns the turn
        return returnTurn;
    }
    static String nextTurnV2(String getTurn2){
        String returnTurn;
        if(getTurn2 == "x"){
            returnTurn = "o";
        }else{
            returnTurn = "x";
        }
        return returnTurn;
    }

    //checks for win conditions
    //changed char to string BECAUSE the way GUI's work. tttGame was made with char values. blank spaces of 'i'
    static boolean checkWin(String[][] boardIn3){
        String pos1 = boardIn3[0][0];
        String pos2 = boardIn3[0][1];
        String pos3 = boardIn3[0][2];
        String pos4 = boardIn3[1][0];
        String pos5 = boardIn3[1][1];
        String pos6 = boardIn3[1][2];
        String pos7 = boardIn3[2][0];
        String pos8 = boardIn3[2][1];
        String pos9 = boardIn3[2][2];
        boolean continueGame = true;
        String winningSide = " ";
        //win conditions

        //horizontal win conditions
        //top row win
        if(pos1 == pos2 && pos1 == pos3 && pos2 == pos3 && pos1 != " " ){
            winningSide = pos1;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + "  is the winner!");
        }
        //mid row win
        if (pos4 == pos5 && pos4 == pos6 && pos5 == pos6 && pos4 != " " ){
            winningSide = pos4;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //bot row win
        if(pos7 == pos8 && pos8 == pos9 && pos7 == pos9 && pos7 != " " ){
            winningSide = pos7;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //vertical win conditions
        //1st row win
        if(pos1 == pos4 && pos4 == pos7 && pos7 == pos1 && pos1 != " " ){
            winningSide = pos1;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //2nd row win
        if(pos2==pos5&&pos5==pos8&&pos8==pos2 && pos2 != " " ){
            winningSide = pos2;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //3rd row win
        if(pos3==pos6&&pos6==pos9&&pos9==pos3 && pos3 != " " ){
            winningSide = pos3;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //diagonal win conditions
        //placement 159
        if(pos1 == pos5 && pos5 == pos9 && pos9 == pos1 && pos5 != " " ){
            winningSide = pos1;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }
        //placement 357
        if(pos3 == pos5 && pos5 == pos7 && pos3 == pos7 && pos5 != " " ){
            winningSide = pos1;
            continueGame = false;
            System.out.println("The game is over");
            System.out.println(winningSide + " is the winner!");
        }

        return continueGame;

    }

    //checks for stalemate
    //update on this, changed char to string because the way GUI's worked (tttGame alone was made with char)
    static boolean checkStalemate(String[][] boardIn3){
        String pos1 = boardIn3[0][0];
        String pos2 = boardIn3[0][1];
        String pos3 = boardIn3[0][2];
        String pos4 = boardIn3[1][0];
        String pos5 = boardIn3[1][1];
        String pos6 = boardIn3[1][2];
        String pos7 = boardIn3[2][0];
        String pos8 = boardIn3[2][1];
        String pos9 = boardIn3[2][2];
        boolean boardIsFull = false;
        boolean continueGame = true;

        if (pos1 != " " && pos2 != " " && pos3 != " " && pos4 != " " && pos5 != " " && pos6 != " " && pos7 != " " && pos8 != " " && pos9 != " ") {
            boardIsFull = true;
            System.out.println("The game board is Full");
        }

        if(boardIsFull){
            continueGame = false;
        }
        return continueGame;
    }

}
