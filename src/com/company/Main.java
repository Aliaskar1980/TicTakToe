package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int playerScore = 0;
    static int computerScore = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] gameBoard = {{'_', '|', '_', '|', '_'},
                              {'_', '|', '_', '|', '_'},
                              {' ', '|', ' ', '|', ' '}};

        printBoard(gameBoard);

        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain) {
            while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
                computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Оюнчуну жалпы балы: " + playerScore);
            System.out.println("Компьютердин жалпы балы: " + computerScore);
            System.out.println("Дагы ойнойсузбу?");
            scanner.nextLine();
            String result = scanner.nextLine();

            switch (result) {
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("КАйра баштайбыз");
                    resetBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;
                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Рахмаат жакшы калыныз");
                    break;
                default:
                    break;
            }
        }
    }

    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            System.out.print(row);
            System.out.println();
        }
    }

    public static void upDateBoard(int position, int player, char[][] gameBoard) {
        char character;
        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }
        switch (position) {
            case 1 -> {
                gameBoard[0][0] = character;
                printBoard(gameBoard);
            }
            case 2 -> {
                gameBoard[0][2] = character;
                printBoard(gameBoard);
            }
            case 3 -> {
                gameBoard[0][4] = character;
                printBoard(gameBoard);
            }
            case 4 -> {
                gameBoard[1][0] = character;
                printBoard(gameBoard);
            }
            case 5 -> {
                gameBoard[1][2] = character;
                printBoard(gameBoard);
            }
            case 6 -> {
                gameBoard[1][4] = character;
                printBoard(gameBoard);
            }
            case 7 -> {
                gameBoard[2][0] = character;
                printBoard(gameBoard);
            }
            case 8 -> {
                gameBoard[2][2] = character;
                printBoard(gameBoard);
            }
            case 9 -> {
                gameBoard[2][4] = character;
                printBoard(gameBoard);
            }
        }
    }

    public static void playerMove(char[][] gameBoard) {
        System.out.println("1-9 чейинки сан бериниз");
        int move = scanner.nextInt();
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            System.out.println("Кечиресиз туура эмес журдунуз");
            move = scanner.nextInt();
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Ойунчу " + move + " сапка жылды");
        upDateBoard(move, 1, gameBoard);
    }

    public static boolean isValidMove(int move, char[][] gameBoard) {
        return switch (move) {
            case 1 -> gameBoard[0][0] == '_';
            case 2 -> gameBoard[0][2] == '_';
            case 3 -> gameBoard[0][4] == '_';
            case 4 -> gameBoard[1][0] == '_';
            case 5 -> gameBoard[1][2] == '_';
            case 6 -> gameBoard[1][4] == '_';
            case 7 -> gameBoard[2][0] == ' ';
            case 8 -> gameBoard[2][2] == ' ';
            case 9 -> gameBoard[2][4] == ' ';
            default -> false;
        };
    }

    public static void computerMove(char[][] gameBoard) {
        Random random = new Random();
        int move = random.nextInt(9) + 1;
        boolean result = isValidMove(move, gameBoard);
        while (!result) {
            move = random.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Компьютер " + move + " сапка жылды");
        upDateBoard(move, 2, gameBoard);

}

    public static boolean isGameOver(char[][] gameBoard) {
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }

//        веритикал
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
//
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Сиз уттунуз");
            playerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Компьютер утту");
            computerScore++;
            return true;
        }

        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' &&
            gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' &&
            gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' '   ) {
            System.out.println("Тен чыктыныз ");
            return true;
        }
        return false;
    }

    public static void resetBoard(char[][] gameBoard) {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}
