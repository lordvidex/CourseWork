package ru.kpfu.Game;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Game {
    //properties
    private static final int PLAYER_CREATE_ERROR = -1;
    private static final int PLAYERS_COUNT = 2;

    //checks if all users are still alive
    private boolean allIsAlive;

    //checks if users have been created
    private boolean isInit;

    //used to indicate turn of players
    private int turn;

    //last force hit of each players
    private final int[] lastMoves;

    private final Player[] players;

    //sorted array of players based on their hp
    private final Player[] leaderboard;

    private final Scanner sc;
    private final int moveCounts;

    public Game() {
        isInit = false;
        turn = 0;
        moveCounts = 0;
        allIsAlive = true;
        lastMoves = new int[PLAYERS_COUNT];
        players = new Player[PLAYERS_COUNT];
        leaderboard = new Player[PLAYERS_COUNT];
        sc = new Scanner(System.in);
        initPlayers();
    }

    //Method that initialises the players
    //здесь можно изменить максимальное hp игроков по умолчанию и др.
    private void initPlayers() {
        System.out.println("Press '1' to use default names or '2' to enter Players' name");
        int choice = sc.nextInt();
        if (choice == 1) {
            for (int i = 0; i < PLAYERS_COUNT; i++) {
                players[i] = new Player();
            }
            isInit = true;
            System.arraycopy(this.players, 0, leaderboard, 0, PLAYERS_COUNT);
        } else if (choice == 2) {
            for (int i = 0; i < PLAYERS_COUNT; i++) {
                System.out.print("ENTER PLAYER " + (i + 1) + " NAME/NICK (without spaces): ");
                String name = sc.next();
                players[i] = new Player(name);
            }
            isInit = true;
            System.arraycopy(this.players, 0, leaderboard, 0, PLAYERS_COUNT);
        } else end();
    }

    //главная функция игры
    public void play() {
        while (allIsAlive) {
            System.out.print(players[turn].getName() + ", enter hit force(1-10): ");
            int force = sc.nextInt();
            if (force > 10 || force < 1) {
                System.out.println("Please use a force from 1-10");
                continue;
            }
            //shoot
            lastMoves[turn] = force;

            for (int i = 0; i < PLAYERS_COUNT; i++) {
                if (i != turn) {
                    if (!players[i].dodgeHit(lastMoves[i]))
                        players[turn].hit(players[i], force);
                }
            }
            turn = (++turn) % PLAYERS_COUNT;
            showScoreBoard();
            updateAliveStatus();
        }
        end();
    }

    //Выводит в Терминале hp игроков каждый раз
    private void showScoreBoard() {
        Arrays.sort(leaderboard, Comparator.comparing(Player::getHp).reversed());
        System.out.println("\033[1mLEADERBOARD\033[0m");
        System.out.printf("\033[1m%d) %s%n\033[0m", 1, leaderboard[0].toString());
        for (int i = 1; i < leaderboard.length; i++) {
            System.out.printf("%d) %s%n", (i + 1), leaderboard[i].toString());
        }
        System.out.println();
    }

    //проверяет если один из игроков уже смерл или hp <= 0
    private void updateAliveStatus() {
        for (Player pl : players) {
            allIsAlive = allIsAlive && pl.isAlive();
        }
    }

    //остановит программу
    public void end() {
        //terminating function
        if (!isInit) {
            System.out.println("Error while creating players");
            System.exit(PLAYER_CREATE_ERROR);
        }
        showScoreBoard();
        System.out.println("THE END: Игрок \"" + leaderboard[0].getName() + "\" ВЫГРАЛИ!!!");
        System.exit(0);
    }
}
