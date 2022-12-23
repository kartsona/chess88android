package com.example.android88;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.android88.databinding.ActivityChessPlayBinding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChessPlay extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityChessPlayBinding binding;

    Button startGame;
    private TextView moveSource = null;
    private static String playerTurn = "white";

    Button drawInitiate;
    Button resignInitiate;

    String move = "Chess?";
    TextView moveTV;

    //GridLayout board;
    //final GridLayout board = (GridLayout) findViewById(R.id.boardGrid);

    private static Pieces array[][] = new Pieces[8][8];
    boolean draw = false;


    //String array[][] = new String[8][8];
    String id[] = new String[65];

    static final String textFile = "Android88SaveFile.txt";

    public String getPos(View v){
        //String pos = "11";
        int boardID = v.getId();

        if(boardID == R.id.board00){
            return "00";
        }
        else if(boardID == R.id.board01){
            return "01";
        }
        else if(boardID == R.id.board02){
            return "02";
        }
        else if(boardID == R.id.board03){
            return "03";
        }
        else if(boardID == R.id.board04){
            return "04";
        }
        else if(boardID == R.id.board05){
            return "05";
        }
        else if(boardID == R.id.board06){
            return "06";
        }
        else if(boardID == R.id.board07){
            return "07";
        }
        else if(boardID == R.id.board10){
            return "10";
        }
        else if(boardID == R.id.board11){
            return "11";
        }
        else if(boardID == R.id.board12){
            return "12";
        }
        else if(boardID == R.id.board13){
            return "13";
        }
        else if(boardID == R.id.board14){
            return "14";
        }
        else if(boardID == R.id.board15){
            return "15";
        }
        else if(boardID == R.id.board16){
            return "16";
        }
        else if(boardID == R.id.board17){
            return "17";
        }
        else if(boardID == R.id.board20){
            return "20";
        }
        else if(boardID == R.id.board21){
            return "21";
        }
        else if(boardID == R.id.board22){
            return "22";
        }
        else if(boardID == R.id.board23){
            return "23";
        }
        else if(boardID == R.id.board24){
            return "24";
        }
        else if(boardID == R.id.board25){
            return "25";
        }
        else if(boardID == R.id.board26){
            return "26";
        }
        else if(boardID == R.id.board27){
            return "27";
        }
        else if(boardID == R.id.board30){
            return "30";
        }
        else if(boardID == R.id.board31){
            return "31";
        }
        else if(boardID == R.id.board32){
            return "32";
        }
        else if(boardID == R.id.board33){
            return "33";
        }
        else if(boardID == R.id.board34){
            return "34";
        }
        else if(boardID == R.id.board35){
            return "35";
        }
        else if(boardID == R.id.board36){
            return "36";
        }
        else if(boardID == R.id.board37){
            return "37";
        }
        else if(boardID == R.id.board40){
            return "40";
        }
        else if(boardID == R.id.board41){
            return "41";
        }
        else if(boardID == R.id.board42){
            return "42";
        }
        else if(boardID == R.id.board43){
            return "43";
        }
        else if(boardID == R.id.board44){
            return "44";
        }
        else if(boardID == R.id.board45){
            return "45";
        }
        else if(boardID == R.id.board46){
            return "46";
        }
        else if(boardID == R.id.board47){
            return "47";
        }
        else if(boardID == R.id.board50){
            return "50";
        }
        else if(boardID == R.id.board51){
            return "51";
        }
        else if(boardID == R.id.board52){
            return "52";
        }
        else if(boardID == R.id.board53){
            return "53";
        }
        else if(boardID == R.id.board54){
            return "54";
        }
        else if(boardID == R.id.board55){
            return "55";
        }
        else if(boardID == R.id.board56){
            return "56";
        }
        else if(boardID == R.id.board57){
            return "57";
        }
        else if(boardID == R.id.board60){
            return "60";
        }
        else if(boardID == R.id.board61){
            return "61";
        }
        else if(boardID == R.id.board62){
            return "62";
        }
        else if(boardID == R.id.board63){
            return "63";
        }
        else if(boardID == R.id.board64){
            return "64";
        }
        else if(boardID == R.id.board65){
            return "65";
        }
        else if(boardID == R.id.board66){
            return "66";
        }
        else if(boardID == R.id.board67){
            return "67";
        }
        else if(boardID == R.id.board70){
            return "70";
        }
        else if(boardID == R.id.board71){
            return "71";
        }
        else if(boardID == R.id.board72){
            return "72";
        }
        else if(boardID == R.id.board73){
            return "73";
        }
        else if(boardID == R.id.board74){
            return "74";
        }
        else if(boardID == R.id.board75){
            return "75";
        }
        else if(boardID == R.id.board76){
            return "76";
        }
        else if(boardID == R.id.board77){
            return "77";
        }
        return null;
    }

    public int getBoardID(int i, int j){
        int returnId = 0;

        if(i == 0 && j == 0){
            returnId = R.id.board00;
        }else if(i == 1 && j == 0){
            returnId = R.id.board10;
        }else if(i == 2 && j == 0){
            returnId = R.id.board20;
        }else if(i == 3 && j == 0){
            returnId = R.id.board30;
        }else if(i == 4 && j == 0){
            returnId = R.id.board40;
        }else if(i == 5 && j == 0){
            returnId = R.id.board50;
        }else if(i == 6 && j == 0){
            returnId = R.id.board60;
        }else if(i == 7 && j == 0){
            returnId = R.id.board70;
        }else

        if(i == 0 && j == 1){
            returnId = R.id.board01;
        }else if(i == 1 && j == 1){
            returnId = R.id.board11;
        }else if(i == 2 && j == 1){
            returnId = R.id.board21;
        }else if(i == 3 && j == 1){
            returnId = R.id.board31;
        }else if(i == 4 && j == 1){
            returnId = R.id.board41;
        }else if(i == 5 && j == 1){
            returnId = R.id.board51;
        }else if(i == 6 && j == 1){
            returnId = R.id.board61;
        }else if(i == 7 && j == 1){
            returnId = R.id.board71;
        }else

        if(i == 0 && j == 2){
            returnId = R.id.board02;
        }else if(i == 1 && j == 2){
            returnId = R.id.board12;
        }else if(i == 2 && j == 2){
            returnId = R.id.board22;
        }else if(i == 3 && j == 2){
            returnId = R.id.board32;
        }else if(i == 4 && j == 2){
            returnId = R.id.board42;
        }else if(i == 5 && j == 2){
            returnId = R.id.board52;
        }else if(i == 6 && j == 2){
            returnId = R.id.board62;
        }else if(i == 7 && j == 2){
            returnId = R.id.board72;
        }else

        if(i == 0 && j == 3){
            returnId = R.id.board03;
        }else if(i == 1 && j == 3){
            returnId = R.id.board13;
        }else if(i == 2 && j == 3){
            returnId = R.id.board23;
        }else if(i == 3 && j == 3){
            returnId = R.id.board33;
        }else if(i == 4 && j == 3){
            returnId = R.id.board43;
        }else if(i == 5 && j == 3){
            returnId = R.id.board53;
        }else if(i == 6 && j == 3){
            returnId = R.id.board63;
        }else if(i == 7 && j == 3){
            returnId = R.id.board73;
        }else

        if(i == 0 && j == 4){
            returnId = R.id.board04;
        }else if(i == 1 && j == 4){
            returnId = R.id.board14;
        }else if(i == 2 && j == 4){
            returnId = R.id.board24;
        }else if(i == 3 && j == 4){
            returnId = R.id.board34;
        }else if(i == 4 && j == 4){
            returnId = R.id.board44;
        }else if(i == 5 && j == 4){
            returnId = R.id.board54;
        }else if(i == 6 && j == 4){
            returnId = R.id.board64;
        }else if(i == 7 && j == 4){
            returnId = R.id.board74;
        }else

        if(i == 0 && j == 5){
            returnId = R.id.board05;
        }else if(i == 1 && j == 5){
            returnId = R.id.board15;
        }else if(i == 2 && j == 5){
            returnId = R.id.board25;
        }else if(i == 3 && j == 5){
            returnId = R.id.board35;
        }else if(i == 4 && j == 5){
            returnId = R.id.board45;
        }else if(i == 5 && j == 5){
            returnId = R.id.board55;
        }else if(i == 6 && j == 5){
            returnId = R.id.board65;
        }else if(i == 7 && j == 5){
            returnId = R.id.board75;
        }else


        if(i == 0 && j == 6){
            returnId = R.id.board06;
        }else if(i == 1 && j == 6){
            returnId = R.id.board16;
        }else if(i == 2 && j == 6){
            returnId = R.id.board26;
        }else if(i == 3 && j == 6){
            returnId = R.id.board36;
        }else if(i == 4 && j == 6){
            returnId = R.id.board46;
        }else if(i == 5 && j == 6){
            returnId = R.id.board56;
        }else if(i == 6 && j == 6){
            returnId = R.id.board66;
        }else if(i == 7 && j == 6){
            returnId = R.id.board76;
        }else

        if(i == 0 && j == 7){
            returnId = R.id.board07;
        }else if(i == 1 && j == 7){
            returnId = R.id.board17;
        }else if(i == 2 && j == 7){
            returnId = R.id.board27;
        }else if(i == 3 && j == 7){
            returnId = R.id.board37;
        }else if(i == 4 && j == 7){
            returnId = R.id.board47;
        }else if(i == 5 && j == 7){
            returnId = R.id.board57;
        }else if(i == 6 && j == 7){
            returnId = R.id.board67;
        }else if(i == 7 && j == 7){
            returnId = R.id.board77;
        }

        return returnId;
    }

    public int getDrawablePiece(String pieceName){

        int piece = 0;

        if(pieceName.equals("bR")){
            return R.drawable.black_rook;
        }else if(pieceName.equals("bN")){
            return R.drawable.black_knight;
        }else if(pieceName.equals("bB")){
            return R.drawable.black_bishop;
        }else if(pieceName.equals("bQ")){
            return R.drawable.black_queen;
        }else if(pieceName.equals("bK")){
            return R.drawable.black_king;
        }else if(pieceName.equals("wR")){
            return R.drawable.white_rook;
        }else if(pieceName.equals("wN")){
            return R.drawable.white_knight;
        }else if(pieceName.equals("wB")){
            return R.drawable.white_bishop;
        }else if(pieceName.equals("wQ")){
            return R.drawable.white_queen;
        }else if(pieceName.equals("wK")){
            return R.drawable.white_king;
        }else if(pieceName.equals("wp")){
            return R.drawable.white_pawn;
        }else{
            return R.drawable.black_pawn;
        }
        //return piece;
    }

    public void setBoard() {

        startGame.setEnabled(false);

        Pawn blackPawn = new Pawn("bp", "black");
        Rook blackRook = new Rook("bR", "black", true);
        Knight blackKnight = new Knight("bN", "black");
        Bishop blackBishop = new Bishop("bB", "black");
        Queen blackQueen = new Queen("bQ", "black");
        King blackKing = new King("bK", "black", true);


        array[0][6] =blackPawn;
        array[1][6] =blackPawn;
        array[2][6] =blackPawn;
        array[3][6] =blackPawn;
        array[4][6] =blackPawn;
        array[5][6] =blackPawn;
        array[6][6] =blackPawn;
        array[7][6] =blackPawn;



        array[0][7] = blackRook;
        array[1][7] = blackKnight;
        array[2][7] = blackBishop;
        array[3][7] = blackQueen;
        array[4][7] = blackKing;
        array[5][7] = blackBishop;
        array[6][7] = blackKnight;
        array[7][7] = blackRook;

        Pawn whitePawn = new Pawn("wp", "white");
        Rook whiteRook = new Rook("wR", "white", true);
        Knight whiteKnight = new Knight("wN", "white");
        Bishop whiteBishop = new Bishop("wB", "white");
        Queen whiteQueen = new Queen("wQ", "white");
        King whiteKing = new King("wK", "white", true);

        array[0][1] = whitePawn;
        array[1][1] = whitePawn;
        array[2][1] = whitePawn;
        array[3][1] = whitePawn;
        array[4][1] = whitePawn;
        array[5][1] = whitePawn;
        array[6][1] = whitePawn;
        array[7][1] = whitePawn;


        array[0][0] = whiteRook;
        array[1][0] = whiteKnight;
        array[2][0] = whiteBishop;
        array[3][0] = whiteQueen;
        array[4][0] = whiteKing;
        array[5][0] = whiteBishop;
        array[6][0] = whiteKnight;
        array[7][0] = whiteRook;

        drawBoard();
    }

    //    private void drawBoard(){
//        startGame.setEnabled(false);
//
//    }
    public void drawBoard(){

        if(move.equals("White's move")){move = "Black's move"; }
        else{move = "White's move";}

        moveTV.setText(move);

        startGame.setEnabled(false);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.println("Array["+ i +"]["+ j +"]:" + array[i][j]);
            }
        }

        TextView textView;
        Drawable dr;

        int pawnLeft = 20;
        int pawnTop = 0;
        int pawnRight = 60;
        int pawnBottom = 60;


        int left = 15;
        int top = 0;
        int right = 70;
        int bottom = 80;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(array[i][j] != null){

                    textView = findViewById(getBoardID(i, j));
                    dr = ResourcesCompat.getDrawable(getResources(), getDrawablePiece(array[i][j].nameAbr), null);
                    dr.setBounds(left,top,right,bottom);
                    textView.setCompoundDrawables( dr, null, null, null );
                }
            }
        }
    }

    public boolean checkBoard(View rv){
        String tempPos = getPos(rv);
        int x = Integer.parseInt(tempPos.substring(0,1));
        int y = Integer.parseInt(tempPos.substring(1, 2));
        return array[x][y] != null;
    }

    public static void saveFile() throws IOException {
        System.out.println("Saving...");


        File file = new File(textFile);

        file.createNewFile();

        FileWriter writer = new FileWriter(file);


        //Need to save each move onboard



        writer.flush();
        writer.close();

        System.out.println("Saving Completed!");
    }

    public void wipeBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                TextView textView = findViewById(getBoardID(i, j));
                array[i][j] = null;
                textView.setCompoundDrawables(null, null, null, null);
            }
        }
    }

    private void onDrawClick() { //draw initiate?
        if(!draw){
            draw = true;
            moveTV.setText("Draw? Hit Draw again to confirm!");
        }
        else{
            draw = false;
            wipeBoard();
            startGame.setEnabled(true);
            moveTV.setText("");
            Toast.makeText(ChessPlay.this, "DRAW" + " selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void onResignClick() { //resign initiate?

        if(move.equals("White's move")){
            move = "Black's Wins";
            wipeBoard();
            startGame.setEnabled(true);
            moveTV.setText("");
            Toast.makeText(ChessPlay.this, "RESIGN" + " selected", Toast.LENGTH_SHORT).show();
            //wipeBoard();
            //onCreate();
            //setBoard();
        }
        else{
            move = "White's Wins";
            wipeBoard();
            startGame.setEnabled(true);
            moveTV.setText("");
            Toast.makeText(ChessPlay.this, "RESIGN" + " selected", Toast.LENGTH_SHORT).show();
            //wipeBoard();
            //setBoard();
        }

        moveTV.setText(move);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //setBoard();

        setContentView(R.layout.activity_chess_play);

        moveTV = findViewById(R.id.PlayerMoveText);
        moveTV.setText(move);

        startGame = findViewById(R.id.startGameButton);
        drawInitiate = findViewById(R.id.buttonDraw);
        resignInitiate = findViewById(R.id.buttonResign);

        //board = findViewById(R.id.boardGrid);

        startGame.setOnClickListener((parent) -> setBoard());
        drawInitiate.setOnClickListener((parent) -> onDrawClick());
        resignInitiate.setOnClickListener((parent) -> onResignClick());

    }

    public void onGridClick(View view) throws IOException { //move maker
        //Toast.makeText(ChessPlay.this, "click", Toast.LENGTH_LONG).show();

        if(playerTurn == "white" ){
//            System.out.println("Player Turn: "+playerTurn);
//            playerTurn = "black";
        }else if(playerTurn == "black") {
            System.out.println("Player Turn: "+playerTurn);
            playerTurn = "white";
        }else{

        }

        TextView tv = (TextView) view;
        String moveSourceName = tv.getResources().getResourceName(tv.getId());

        if(!(startGame.isEnabled())){
            if(moveSource == null && checkBoard(view)){
                moveSource = tv;
                //moveSource.setBackgroundColor(Color.BLUE);
                Toast.makeText(ChessPlay.this, moveSourceName + " selected", Toast.LENGTH_SHORT).show();
            }

            else if(tv == moveSource && checkBoard(view)){
                moveSource = null;
                //moveSource.setBackgroundColor(this.getResources().getColor(R.color.boardColorDark));
                Toast.makeText(ChessPlay.this, moveSourceName + " deselected", Toast.LENGTH_SHORT).show();
            }

            else if(moveSource != null){
                //make move

                String sourcePosStr = getPos(moveSource);
                String destPosStr = getPos(view);
                int currX = Integer.parseInt(sourcePosStr.substring(0,1));
                int currY = Integer.parseInt(sourcePosStr.substring(1,2));

                int nextX = Integer.parseInt(destPosStr.substring(0,1));
                int nextY = Integer.parseInt(destPosStr.substring(1,2));

                if(array[currX][currY].nameAbr.equals("wp") || array[currX][currY].nameAbr.equals("bp")){
                    if(((Pawn) array[currX][currY]).isValid(array[currX][currY].color, currX, currY, nextX, nextY) || (array[nextX][nextY] != null &&
                            ((Pawn) array[currX][currY]).isEnpassant(array[currX][currY].color, currX, currY,array[nextX][nextY].color ,nextX, nextY))
                    ){

                        //array[nextX][nextY] = new Pawn((Pawn)array[currX][currY]);
                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                        //saveFile(currX + "" + currY + " " + nextX + "" + nextY);
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(ChessPlay.this, "move valid", Toast.LENGTH_LONG).show();
                }
                else if(array[currX][currY].nameAbr.equals("wN") || array[currX][currY].nameAbr.equals("bN")){
                    if(((Knight) array[currX][currY]).isValid(array, array[currX][currY].color, currX, currY, nextX, nextY)){

                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                }
                else if(array[currX][currY].nameAbr.equals("wB") || array[currX][currY].nameAbr.equals("bB")){
                    if(((Bishop) array[currX][currY]).isValid(array, array[currX][currY].color, currX, currY, nextX, nextY)){

                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                }
                else if(array[currX][currY].nameAbr.equals("wK") || array[currX][currY].nameAbr.equals("bK")){
                    if(((King) array[currX][currY]).isValid(array, array[currX][currY].color, currX, currY, nextX, nextY)){

                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                }
                else if(array[currX][currY].nameAbr.equals("wQ") || array[currX][currY].nameAbr.equals("bQ")){
                    if(((Queen) array[currX][currY]).isValid(array, array[currX][currY].color, currX, currY, nextX, nextY)){

                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                }
                else if(array[currX][currY].nameAbr.equals("wR") || array[currX][currY].nameAbr.equals("bR")){
                    if(((Rook) array[currX][currY]).isValid(array, array[currX][currY].color, currX, currY, nextX, nextY)){

                        array[nextX][nextY] = array[currX][currY];
                        array[currX][currY] = null;

                        moveSource.setCompoundDrawables(null, null, null, null);
                        drawBoard();
                    }
                    else{
                        Toast.makeText(ChessPlay.this, "move invalid", Toast.LENGTH_LONG).show();
                    }
                }

                else{
                    Toast.makeText(ChessPlay.this, "invalid", Toast.LENGTH_LONG).show();
                    moveSource = null;
                }

                moveSource = null;
            }
        }
    }




    public String toString(){
        return array.toString();
    }
}