package com.softserve.nedeleva.chessboard;

import java.util.Scanner;

/**
  Вывести шахматную доску с заданными размерами высоты и ширины, по принципу:
   * * * * * *
    * * * * * *
   * * * * * *
    * * * * * *
  Программа запускается через вызов главного класса с параметрами.
 */
public class ChessBoard {
    private int height;
    private int width;

    ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    static void createChessBoard(ChessBoard chessBoard) {
        for (int i = 0; i < chessBoard.height; i++) {
            for (int j = 0; j < chessBoard.width; j++) {
                System.out.print(((i + j) % 2 == 0) ? "◽️" : "⬛️");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        ChessBoard chessBoard = new ChessBoard(h, w);
        ChessBoard.createChessBoard(chessBoard);
    }
}

