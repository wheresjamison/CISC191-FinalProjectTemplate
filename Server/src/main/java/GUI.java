import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    tttGame game = new tttGame();

    JTextField outputText;

    private JButton pos1;
    private JButton pos2;
    private JButton pos3;
    private JButton pos4;
    private JButton pos5;
    private JButton pos6;
    private JButton pos7;
    private JButton pos8;
    private JButton pos9;
    private JButton start;
    private JButton newGame;
    private JButton backToStartScreen;

    private JLabel p1, p2;
    private JLabel p1Score, p2Score;

    public String turn = "x";
    public int posNumber;
    public int xp1 = 0;
    public int xp2 = 0;
    public int turnCounter = 0;
    public char whosX = 'x';
    public boolean winByWin = false;
    public boolean winByStalemate = false;
    String bs = " "; //bs = blank space

    public GUI(){
        JPanel tttPanel = new JPanel();
        JFrame tttFrame = new JFrame();

        //labels
        p1 = new JLabel("(x)" + "Player 1: ");
        p2 = new JLabel("(o)" + "Player 2: ");
        JTextField p1Name = new JTextField(20);
        JTextField p2Name = new JTextField(20);
        p1Name.setText("Enter Name for player 1");
        p2Name.setText("Enter name for player 2");
        p1Name.setEditable(true);
        p2Name.setEditable(true);
        p1Score = new JLabel(String.valueOf(xp1));
        p2Score = new JLabel(String.valueOf(xp2));

        //buttons
        pos1 = new JButton(game.board[0][0]);
        pos2 = new JButton(game.board[0][1]);
        pos3 = new JButton(game.board[0][2]);
        pos4 = new JButton(game.board[1][0]);
        pos5 = new JButton(game.board[1][1]);
        pos6 = new JButton(game.board[1][2]);
        pos7 = new JButton(game.board[2][0]);
        pos8 = new JButton(game.board[2][1]);
        pos9 = new JButton(game.board[2][2]);
        //menu buttons
        start = new JButton("Start");
        newGame = new JButton("New Game");
        backToStartScreen = new JButton("Back");

        //turn printer
        outputText = new JTextField();
        if(turnCounter == 0 ){
            outputText.setText("It is " + turn + " 's turn");
        }
        outputText.setEditable(false);
        tttFrame.add(outputText);

        //layout
        GridBagConstraints layoutConst = null;
        tttPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        tttPanel.setLayout(new GridLayout(4,5));

        //adding buttons
        tttPanel.add(pos1);
        tttPanel.add(pos2);
        tttPanel.add(pos3);
        tttPanel.add(pos4);
        tttPanel.add(pos5);
        tttPanel.add(pos6);
        tttPanel.add(pos7);
        tttPanel.add(pos8);
        tttPanel.add(pos9);

        tttPanel.add(start);
        tttPanel.add(backToStartScreen);
        tttPanel.add(newGame);
        tttPanel.add(p1);
        tttPanel.add(p2);

        //alex's method
        tttFrame.add(tttPanel, BorderLayout.CENTER);
        tttFrame.setSize(800,800);
        tttFrame.setTitle("A.Legaspi's TicTacToe");
        tttFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tttFrame.setVisible(true);

        //move to top of the paper
        tttFrame.setLayout(new GridBagLayout());
        //grid layout
        //start
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(start,layoutConst);
        //pos1-3
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos1,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 3;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos2,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 4;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos3,layoutConst);
        //back
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(backToStartScreen,layoutConst);
        //pos 4-6
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos4,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 3;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos5,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 4;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos6,layoutConst);
        //new game
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(newGame,layoutConst);
        //pos 7-9
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos7,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 3;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos8,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 4;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(pos9,layoutConst);
        //p1
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p1,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p1Name,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 4;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p1Score,layoutConst);

        //p2
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p2,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p2Name,layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 4;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(p2Score ,layoutConst);
        //tells whos turn it is
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(10,10,10,10);
        tttFrame.add(outputText,layoutConst);

        /*
        removed these two last minute because I decided not to have
        different windows for 1 and 2 players, game will only be 2 players
         */
        start.setVisible(false);
        backToStartScreen.setVisible(false);

        pos1.addActionListener(this);
        pos2.addActionListener(this);
        pos3.addActionListener(this);
        pos4.addActionListener(this);
        pos5.addActionListener(this);
        pos6.addActionListener(this);
        pos7.addActionListener(this);
        pos8.addActionListener(this);
        pos9.addActionListener(this);
        newGame.addActionListener(this);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public void gameWinStateText(){
        outputText.setText(turn + "wins");
    }
    public void gameStalemateStateText(){
        outputText.setText("No one wins, the game ends in a stalemate!");
    }
    public void emptyBoard(){
        pos1.setText(bs);
        pos2.setText(bs);
        pos3.setText(bs);
        pos4.setText(bs);
        pos5.setText(bs);
        pos6.setText(bs);
        pos7.setText(bs);
        pos8.setText(bs);
        pos9.setText(bs);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object b = e.getSource();
        if(b==pos1){
            posNumber = 1;
            tttGame.convertPos(posNumber);
            pos1.setText(String.valueOf(turn));
            game.board[0][0] = (String.valueOf(turn));
        }
        if(b==pos2){
            posNumber = 2;
            tttGame.convertPos(posNumber);
            pos2.setText(String.valueOf(turn));
            game.board[0][1] = (String.valueOf(turn));
        }
        if(b==pos3){
            posNumber = 3;
            tttGame.convertPos(posNumber);
            pos3.setText(String.valueOf(turn));
            game.board[0][2] = (String.valueOf(turn));
        }
        if(b==pos4){
            posNumber = 4;
            tttGame.convertPos(posNumber);
            pos4.setText(String.valueOf(turn));
            game.board[1][0] = (String.valueOf(turn));
        }
        if(b==pos5){
            posNumber = 5;
            tttGame.convertPos(posNumber);
            pos5.setText(String.valueOf(turn));
            game.board[1][1] = (String.valueOf(turn));
        }
        if(b==pos6){
            posNumber = 6;
            tttGame.convertPos(posNumber);
            pos6.setText(String.valueOf(turn));
            game.board[1][2] = (String.valueOf(turn));
        }
        if(b==pos7){
            posNumber = 7;
            tttGame.convertPos(posNumber);
            pos7.setText(String.valueOf(turn));
            game.board[2][0] = (String.valueOf(turn));
        }
        if(b==pos8){
            posNumber = 8;
            tttGame.convertPos(posNumber);
            pos8.setText(String.valueOf(turn));
            game.board[2][1] = (String.valueOf(turn));
        }
        if(b==pos9){
            posNumber = 9;
            tttGame.convertPos(posNumber);
            pos9.setText(String.valueOf(turn));
            game.board[2][2] = (String.valueOf(turn));
        }
        if(b==newGame){
            posNumber = 0;
            tttGame.convertPos(posNumber);
            turnCounter = 0;

            //resets all the buttons to " "
            for(int a=0; a<3; a++){
                for(int c=0; c<3; c++){
                    game.board[a][c] = bs;
                }
            }
            emptyBoard();
            outputText.setText("New game, it is " + turn + " 's turn!");
        }
        turn = (tttGame.nextTurnV2(turn));
        turnCounter++;
        boolean winByWin = tttGame.checkWin(game.board);
        boolean winByStalemate = tttGame.checkStalemate(game.board);
        if(!winByWin){
            outputText.setText((tttGame.nextTurnV2(turn))+ " wins");
            if(turn=="o"){
                xp1++;
                p1Score.setText(String.valueOf(xp1));
            }
            if(turn=="x"){
                xp2++;
                p2Score.setText(String.valueOf(xp2));
            }
        } else if(!winByStalemate){
            outputText.setText("No one wins, the game ends in a stalemate!");
        } else{
            outputText.setText("it is " + turn + " 's turn");
        }

    }
}
