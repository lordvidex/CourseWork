package dev.druid.classwork.classwork4;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 25.02.2021
 * Time: 4:39 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */

public class MineSweeper {
    final static char FLAG = 'F';
    final static char BOMB = 'B';
    final static char OPENED = 'O';
    final static char HIDDEN = '-';
    static int bombCount;
    static Scanner sc;
    static boolean[][] hiddenGameField;
    static char[][] shownGameField;
    static int[] userXY;
    static Queue<Point> gameQueue;

    public static void main(String[] args) {
        // Receive from the user:
        //      - Size of the board
        //      - Game level
        // Initialise the game board with the data gotten from the user
        gameInit();

        // Game loop
        // Game is won IF there are no HIDDEN fields and all BOMB fields are marked FLAG
        gamePlay();
    }

    private static void gameInit() {
        sc = new Scanner(System.in);
        // welcome message
        System.out.println(" Welcome to MINESWEEPER!\nSETUP:-");

        // n - where n is rowCount and columnCount
        int size = getBoardSize();

        // EASY, MEDIUM, HARD
        String s = getDifficulty();

        // init boards with size
        hiddenGameField = new boolean[size][size];
        shownGameField = new char[size][size];

        // fill bombs at random pos
        // depending on difficulty level
        fillBombs(s);

        // hide all the user fields at init
        fillShownFields();
    }

    /**
     * @return size - the size of the board
     * which must be >= 5 and <= 26
     */
    private static int getBoardSize() {
        int size;
        do {
            System.out.println("Enter the size of field >=5 && <=26");
            size = Integer.parseInt(sc.nextLine().trim());
        } while (size < 5 || size > 26);
        return size;
    }


    /**
     * Requests user to enter difficulty and repeats if
     * input is invalid
     *
     * @return "/e", "/m", "/h" for easy,medium and hard respectively
     */
    private static String getDifficulty() {
        do {
            System.out.println("Enter the difficulty you want: " +
                    "/e - EASY" +
                    "\t/m - MEDIUM" +
                    "\t\t" +
                    "/h - HARD");
            String input = sc.nextLine().trim();
            switch (input) {
                case "/e":
                case "/m":
                case "/h":
                    return input;
                default:
                    break;
            }
            System.out.println("You entered a wrong value!");
        } while (true);
    }

    private static void fillShownFields() {
        int len = shownGameField.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                shownGameField[i][j] = HIDDEN;
            }
        }
    }

    private static void fillBombs(String s) {
        int len = hiddenGameField.length;
        // bombCount is more for harder levels and lesser for easier levels
        // medium by default
        int diff = 4; // MEDIUM
        switch (s) {
            case "/e":
                diff = 8; //EASY
                break;
            case "/h":
                diff = 3; //HARD
                break;
            default:
                break;
        }
        bombCount = (len * len) / diff;
        for (int i = 0; i < bombCount; i++) {
            int r = new Random().nextInt(len * len);
            int row = r / len;
            int col = r % len;
            hiddenGameField[row][col] = true;
        }
    }

    /**
     * @return true if all fields are exposed, and all bombs are FLAGed
     * false otherwise
     */
    private static boolean isGameWon() {
        int len = shownGameField.length;
        int suspected = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (hiddenGameField[i][j] && shownGameField[i][j] == FLAG) {
                    suspected++;
                } else if (!hiddenGameField[i][j] && shownGameField[i][j] == HIDDEN) {
                    return false;
                }
            }
        }
        return suspected == bombCount;
    }

    private static void gamePlay() {
        boolean gameOver = false;
        userXY = new int[2];
        gameQueue = new LinkedList<>();
        showPlayerBoard();

        while (!gameOver) {
            // check winning conditions first
            if (isGameWon()) {
                System.out.println("Congratulations! You won the game!");
                break;
            }

            String userInput = getInputFromUser(
                    "Enter two characters [A-Z][1-26] to move cursor to position");

            String condition = getInputFromUser("""
                    Enter 'F' to add flag,
                    Enter 'x' to open field""");
            if (userInputIsValid(userInput)) {
                if (condition.equals("F")) {
                    shownGameField[userXY[0]][userXY[1]] = FLAG;
                } else if (!hiddenGameField[userXY[0]][userXY[1]]) {
                    addToProcessQueue(new Point(userXY[0], userXY[1]));
                    openCellsInQueue();
                } else {
                    gameOver = true;
                    openAllBombCells();
                    System.out.println("Game Over! You pressed a bomb :(");
                }
            }
            showPlayerBoard();
        }
    }

    private static String getInputFromUser(String message) {
        System.out.println(message);
        return sc.nextLine().trim().toUpperCase();
    }

    private static void showPlayerBoard() {
        System.out.print("    ");
        int len = shownGameField.length;
        for (int i = 0; i < len; i++) {
            System.out.printf("%3d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.printf("%4c", 'A' + i);
            for (int j = 0; j < len; j++) {
                System.out.printf("%3c", shownGameField[i][j]);
            }
            System.out.println();
        }
    }

    private static void openAllBombCells() {
        int len = hiddenGameField.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (hiddenGameField[i][j]) {
                    shownGameField[i][j] = BOMB;
                }
            }

        }
    }

    private static void openCellsInQueue() {
        while (!gameQueue.isEmpty()) {
            Point current = gameQueue.remove();
            int neighbouringBombs = getNeighbouringBombsFrom(current);
            if (neighbouringBombs != 0) {
                // open the current cell and show the neighboring bombs
                shownGameField[current.x][current.y] = (char) (neighbouringBombs + '0');
            } else {
                shownGameField[current.x][current.y] = OPENED;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        // all neighbours (STRICTLY)
                        boolean isNotIandJ = !(i == 0 && j == 0);
                        if (isNotIandJ &&
                                isInRange(current.x + i, current.y + j) &&
                                shownGameField[current.x + i][current.y + j] == HIDDEN) {
                            addToProcessQueue(new Point(current.x + i, current.y + j));
                        }
                    }
                }
            }
        }
    }

    private static int getNeighbouringBombsFrom(Point current) {
        int bombs = 0;
        //x-1,y-1
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // all neighbours (it is not a bomb itself.. so, we can loop when i==0&&j==0)
                if (isInRange(current.x + i, current.y + j)) {
                    if (hiddenGameField[current.x + i][current.y + j]) {
                        bombs++;
                    }
                }
            }
        }
        return bombs;
    }

    private static boolean isInRange(int x, int y) {
        int len = shownGameField.length;
        return x >= 0 && y >= 0 && x < len && y < len;
    }

    private static void addToProcessQueue(Point point) {
        gameQueue.offer(point);
    }

    /**
     * @param userInput - a 2-3 character string denoting a cell's position
     * @return true - the value entered is within range and cell has not been opened
     */
    private static boolean userInputIsValid(String userInput) {
        if (userInput.length() >= 2) {
            // check that the first char is a letter from 'A' to 'Z'
            // and the second is a digit from 1 to 26
            int dist = userInput.charAt(0) - 'A';

            int dist2 = Integer.parseInt(userInput.substring(1)) - 1;
            // check if field is out of bounds or has been opened before
            if (dist >= shownGameField.length
                    || dist2 >= shownGameField.length
                    || !(shownGameField[dist][dist2] == HIDDEN
                        || shownGameField[dist][dist2] == FLAG)) {
                return false;
            } else {
                userXY[0] = dist;
                userXY[1] = dist2;
                return true;
            }
        }
        return false;
    }

    /**
     * A struct for holding
     * two integer values,
     * x & y
     */
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
