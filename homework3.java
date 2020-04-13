//Лежень Л.Л.
package ru.homework.lesson3;

import java.util.Random;
import java.util.Scanner;

public class homework3 {

    private static final int fieldSizeY = 3;
    private static final int fieldSizeX = 3;
    private static char[][] field = new char[fieldSizeY][fieldSizeX];

    private static Scanner SCANNER = new Scanner (System.in);
    private static Random RANDOM = new Random ();

    private static final char HUMAN_DOT  = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';
    private static final int TO_WIN = 3;

    public static void initMap() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
    public static void printMap() {
        System.out.println ("-------");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print ("|");
            for (int j = 0; j < fieldSizeY; j++) {
                System.out.print (field[i][j] + "|");
            }
            System.out.println ();
        }
        System.out.println ("-------");
    }
    public static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }
    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println ("Введите координаты: X (от 1 до " + fieldSizeY + ")   Y  (от 1 до " + fieldSizeX+ ")");
            x = SCANNER .nextInt () - 1;
            y = SCANNER .nextInt () - 1;
        } while (!isCellValid (y, x));
        setSym (y, x, HUMAN_DOT );
    }
    public static void aiTurn() {
        for (int i = 0; i < fieldSizeX; i++)
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellValid (i, j)) {
                    setSym (i, j, AI_DOT);
                    if (checkWin (AI_DOT)) return;
                    setSym (i, j, EMPTY_DOT);
                }
            }

        for (int i = 0; i < fieldSizeX; i++)
            for (int j = 0; j < fieldSizeY; j++) {
               if (isCellValid (i, j)) {
                   setSym (i, j, HUMAN_DOT );
                    if (checkWin (HUMAN_DOT )) {
                        setSym (i, j, AI_DOT);
                        return;
                    }
                    setSym (i, j, EMPTY_DOT);
                }
            }

        int x;
        int y;
        do {
            x = RANDOM.nextInt (fieldSizeY);
            y = RANDOM.nextInt (fieldSizeX);
        } while (!isCellValid (y, x));
        setSym (y, x, AI_DOT);
    }
    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > fieldSizeY- 1 || y > fieldSizeX - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    //     Переделать проверку победы, чтобы она не была реализована просто набором условий.
    private static boolean checkWin(char sym) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine (i, j, 0, 1, sym)) return true;
                if (checkLine (i, j, 1, 1, sym)) return true;
                if (checkLine (i, j, 1, 0, sym)) return true;
                if (checkLine (i, j, -1, 1, sym)) return true;
            }
        }
        return false;
    }
    private static boolean checkLine(int y, int x, int vy, int vx, char sym) {
        int wayX = x + (TO_WIN - 1) * vx;
        int wayY = y + (TO_WIN - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > fieldSizeY - 1 || wayY > fieldSizeX - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        initMap ();
        printMap ();

        while (true) {
            humanTurn ();
            printMap ();
            if (checkWin (HUMAN_DOT )) {
                System.out.println ("PLAYER WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println ("DRAW!");
                break;
            }
            aiTurn();
            printMap();
           if (checkWin (AI_DOT)) {
              System.out.println ("AI_DOT WIN!");
               break;
            }

        }
    }
}