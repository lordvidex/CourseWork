package ru.kpfu.EightQueens;

/**
 * Created by IntelliJ IDEA
 * Date: 26.12.2020
 * Time: 14:04
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: Board class for handling ChessBoard related methods
 *
 */
public class Board {
    private final int size;
    private final int[][] field;

    public Board(int size) {
        this.size = size;
        this.field = new int[size][size];
    }

    public Board(Board newBoard){
        this.size = newBoard.getSize();
        this.field = new int[size][size];
        int[][] newBoardField = newBoard.getField();
        for(int i = 0;i<size;i++){
            System.arraycopy(newBoardField[i], 0, this.field[i], 0, size);
        }
    }
    public int getSize(){
        return this.size;
    }
    public int[][] getField(){
        return this.field;
    }
    public void place(int row, int col) {
        //queen place is 1
        this.field[row][col] = 1;
        remove(row,col);
        //affected places is 2 which are gotten from the remove method
    }

    /**
     * @param: trow - temporary mutable value of row
     * @param: tcol - temporary mutable value of col
     */
    private void remove(int row, int col) {
        int trow;
        int tcol;

        //remove all horizontal pieces
        for(int i = 0;i<col;i++){
            this.field[row][i] = 2;
        }
        for(int i = col+1;i<size;i++){
            this.field[row][i] = 2;
        }

        //remove all vertical pieces
        for(int i = 0;i<row;i++){
            this.field[i][col] = 2;
        }
        for(int i = row+1;i<size;i++) {
            this.field[i][col] = 2;
        }

        // remove all principal diagonals
        //UP
        trow = row;
        tcol = col;
        while(trow-1>=0&&tcol-1>=0){
            this.field[--trow][--tcol] = 2;
        }
        //DOWN
        trow = row;
        tcol = col;
        while(trow+1<size&&tcol+1<size){
            this.field[++trow][++tcol] = 2;
        }

        //remove all secondary diagonals
        //UP
        trow = row;
        tcol = col;
        while(trow-1>=0&&tcol+1<size){
            this.field[--trow][++tcol] = 2;
        }
        //DOWN
        trow = row;
        tcol = col;
        while(tcol-1>=0&&trow+1<size){
            this.field[++trow][--tcol] = 2;
        }
    }

    public boolean isSafe(int row, int col) {
        return this.field[row][col] == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.field[i][j] == 1) res.append(" Q ");
                else res.append(" ").append('.').append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
