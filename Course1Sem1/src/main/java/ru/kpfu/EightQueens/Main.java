package ru.kpfu.EightQueens;

/**
 * Created by IntelliJ IDEA
 * Date: 26.12.2020
 * Time: 14:13
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: расстановка 8 ферзей на шахматной доске
 */
public class Main {
    //кол. способов расположения ферзей на шахматной доске
    static int count = 0;

    //это можно поменять.. зависит от кол. строки на шахматной доске
    final static int SIZE = 8;

    public static void main(String[] args){
        Board chessBoard = new Board(SIZE);
        for(var i = 0;i<=SIZE-8;i++){
            getMaxQueenBoard(chessBoard,0,i);
        }
        //ВНИМАНИЕ: это всегда аккуратно когда (SIZE==8)
        // и (count <= кол. способов) когда (SIZE>8)
        //Ответы нет когда (SIZE<8) потому что не возможно перестановит 8 ферзы
        System.out.println("Существует "+count+" возможное расположение ферзей на шахматной доске так, чтобы они не убивали друг друга");
    }

    /**
     * рекурсивний метод который найти всё возможные перестановки
     * @param chessBoard - текущая шахматная доска
     * @param queenRow - позиция строке текущей ферзей
     * @param queens - количество ферзы на шакматной доске
     */
    public static void getMaxQueenBoard(Board chessBoard,int queens,int queenRow){
        if(queens==8){
            count++;
            System.out.println(chessBoard.toString());
        }
        if(queenRow==SIZE){
            return ;
        }
        for(int i = 0;i<SIZE;i++){
            if(chessBoard.isSafe(queenRow,i)){
                Board freshBoard = new Board(chessBoard);
                freshBoard.place(queenRow,i);
                getMaxQueenBoard(freshBoard,queens+1,queenRow+1);
            }
        }
    }
}
