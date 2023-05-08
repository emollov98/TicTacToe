import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demo {

    private static int count = 0;
    private static int target = 3;
    private static int cornerCounter = 0;
    private static boolean isMade = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Game is started");
        System.out.println("Instructions: \n you will see a square that show you" +
                " numbers and their positions. \n Type your number to make a move.\n If you forget" +
                "Numbers and their places in the squares type 0");
        showInstructions();
        System.out.println();
        System.out.println();
        String[][] game = new String[3][3];
        createGame(game);
        showGame(game);
        String gameType = "";
        do {
            if (!gameType.equalsIgnoreCase("F")
                    || !gameType.equalsIgnoreCase("C")) {
                System.out.println("Choose mode: \n if you want to play with friend type F." +
                        " \n if u want to play against computer type C");
            }
            gameType = sc.nextLine();
        } while (!gameType.equalsIgnoreCase("F")
                && !gameType.equalsIgnoreCase("C"));

        if (gameType.equalsIgnoreCase("F")) {
            System.out.println(" ================ Start play! =============== ");
            System.out.println("Player 1 please enter your name: ");
            String player1 = sc.nextLine();
            System.out.println("Player 2 please enter your name: ");
            String player2 = sc.nextLine();
            System.out.println("Who is going to be first will be decided by PC, so you wont get mad each other!");
            playWithFriend(game, player1, player2);
        } else if (gameType.equalsIgnoreCase("C")) {
            System.out.println("Please enter your name: ");
            String player1 = sc.nextLine();
            playAgainstAI(game, player1);
        } else {

        }

    }

    private static void playAgainstAI(String[][] game, String name) {
        Scanner sc = new Scanner(System.in);
        boolean isFinished = false;
        List<Integer> played = new ArrayList<>();
        int move = 0;

        while (!isFinished) {
            System.err.println(name + " make your move");
            move = sc.nextInt();
            if (!played.contains(move)) {
                if (move >= 0 && move <= 9) {
                    if (move != 0) {
                        played.add(move);
                        playerMove(game, move);
                    }
                } else {
                    System.out.println("Invalid input! Chose a number from 1 to 9 and 0 too see instructions.");
                    showGame(game);
                }
            } else {
                System.out.println("This square is taken. You have to move to another square");
                showGame(game);
                continue;
            }
            if (played.size() >= 9) {
                System.out.println("Game over!");
                if (!gameChecker(game)) {
                    System.out.println("No winner, game is equal!");
                    return;
                }
                return;
            }
            isFinished = gameChecker(game);
            if (isFinished) {
                System.out.println("Game over!");
                System.out.println("The winner is " + name);
                return;
            }
            computerMove(game, played);
            isFinished = gameChecker(game);
            if (isFinished) {
                System.out.println("Game over!");
                System.out.println("The winner is computer");
                return;
            }

        }
    }

    private static boolean defenceCenterMove(String[][] game, List<Integer> played) {
        if (game[0][0].equals("X") && game[0][1].equals("X")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("X") && game[0][2].equals("X")) {
            if (!played.contains(2)) {
                game[0][1] = "O";
                played.add(2);
                showGame(game);
                return true;
            }
        }
        if (game[0][1].equals("X") && game[0][2].equals("X")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("X") && game[1][1].equals("X")) {
            if (!played.contains(6)) {
                game[1][2] = "O";
                played.add(6);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("X") && game[1][2].equals("X")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("X") && game[1][2].equals("X")) {
            if (!played.contains(4)) {
                game[1][0] = "O";
                played.add(4);
                showGame(game);
                return true;
            }
        }
        if (game[2][0].equals("X") && game[2][1].equals("X")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[2][0].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(8)) {
                game[2][1] = "O";
                played.add(8);
                showGame(game);
                return true;
            }
        }
        if (game[2][1].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        //vertcals
        if (game[0][0].equals("X") && game[1][0].equals("X")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("X") && game[2][0].equals("X")) {
            if (!played.contains(4)) {
                game[1][0] = "O";
                played.add(4);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("X") && game[2][0].equals("X")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        //done
        if (game[0][1].equals("X") && game[1][1].equals("X")) {
            if (!played.contains(8)) {
                game[2][1] = "O";
                played.add(8);
                showGame(game);
                return true;
            }
        }
        if (game[0][1].equals("X") && game[2][1].equals("X")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("X") && game[2][1].equals("X")) {
            if (!played.contains(2)) {
                game[0][1] = "O";
                played.add(2);
                showGame(game);
                return true;
            }
        }
        //done
        if (game[0][2].equals("X") && game[1][2].equals("X")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[0][2].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(6)) {
                game[1][2] = "O";
                played.add(6);
                showGame(game);
                return true;
            }
        }
        if (game[1][2].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        //доне
        if (game[0][0].equals("X") && game[1][1].equals("X")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("X") && game[2][2].equals("X")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        //доне
        if (game[2][0].equals("X") && game[1][1].equals("X")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        if (game[0][2].equals("X") && game[2][0].equals("X")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("X") && game[0][2].equals("X")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        return false;
    }

    private static void computerMove(String[][] game, List<Integer> played) {
        System.out.println("Computer moved");
        int row = new Random().nextInt(3);
        int column = new Random().nextInt(3);
        if (finishMove(game, played)) {
            return;
        } else {
            if (defenceCenterMove(game, played)) {
                return;
            } else if (defenceCornerMove(game, played) && count==2) {
                    return;
            } else if (count < target) {
                while (((row == 0 && column == 1) || (row == 1 && column == 0) ||
                        (row == 1 && column == 2) || (row == 2 && column == 1))
                        || (game[row][column].equals("X") || game[row][column].equals("O"))) {
                    row = new Random().nextInt(3);
                    column = new Random().nextInt(3);
                }
            } else {
                while (game[row][column].equals("X") || game[row][column].equals("O")) {
                    row = new Random().nextInt(3);
                    column = new Random().nextInt(3);
                    if (played.size() >= 9) {
                        return;
                    }
                }
            }
        }

        count++;
        game[row][column] = "O";
        showGame(game);
        if (row == 0 && column == 0) {
            played.add(1);
        }
        if (row == 0 && column == 1) {
            played.add(2);
        }
        if (row == 0 && column == 3) {
            played.add(3);
        }
        if (row == 1 && column == 0) {
            played.add(4);
        }
        if (row == 1 && column == 1) {
            played.add(5);
        }
        if (row == 1 && column == 2) {
            played.add(6);
        }
        if (row == 2 && column == 0) {
            played.add(7);
        }
        if (row == 2 && column == 1) {
            played.add(8);
        }
        if (row == 2 && column == 2) {
            played.add(9);
        }

    }

    private static boolean defenceCornerMove(String[][] game, List<Integer> played) {
        if (isMade){
            return false;
        }
        isMade = true;
        if (game[0][0].equals("X") && game[2][1].equals("X")) {
            return tryToAttack(game, played);
        }
        if (game[0][2].equals("X") && game[2][1].equals("X")) {
            return tryToAttack1(game, played);
        }
        if (game[0][0].equals("X") && game[1][2].equals("X")) {
            return tryToAttack2(game, played);
        }
        if (game[0][2].equals("X") && game[1][0].equals("X")) {
            return tryToAttack3(game, played);
        }
        if (game[2][0].equals("X") && game[0][1].equals("X")) {
            return tryToAttack4(game, played);
        }
        if (game[2][2].equals("X") && game[0][1].equals("X")) {
            return tryToAttack5(game, played);
        }
        if (game[2][0].equals("X") && game[1][2].equals("X")) {
            return tryToAttack6(game, played);
        }
        if (game[0][0].equals("X") && game[2][1].equals("X")) {
            return tryToAttack7(game, played);
        }
        return false;
    }

    private static boolean tryToAttack7(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[0][1].equalsIgnoreCase("O")){
                    if (!played.contains(2)) {
                        game[1][2] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(2)) {
                        game[0][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack6(String[][] game, List<Integer> played) {

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[0][2].equalsIgnoreCase("O")){
                    if (!played.contains(2)) {
                        game[0][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(2)) {
                        game[0][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack5(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[0][2].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(4)) {
                        game[1][0] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(4)) {
                        game[1][0] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack4(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(6)) {
                        game[1][2] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[0][2].equalsIgnoreCase("O")){
                    if (!played.contains(6)) {
                        game[1][2] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack3(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(8)) {
                        game[2][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(8)) {
                        game[2][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack2(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[0][2].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(8)) {
                        game[2][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(8)) {
                        game[2][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean tryToAttack1(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[0][0].equalsIgnoreCase("O")){
                    if (!played.contains(4)) {
                        game[1][0] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(4)) {
                        game[1][0] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;

    }

    private static boolean tryToAttack(String[][] game, List<Integer> played) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[0][2].equalsIgnoreCase("O")){
                    if (!played.contains(6)) {
                        game[1][2] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
                else if (game[2][2].equalsIgnoreCase("O")){
                    if (!played.contains(6)) {
                        game[1][2] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }

                }
                else if(game[2][0].equalsIgnoreCase("O")){
                    if (!played.contains(5)) {
                        game[1][1] = "O";
                        played.add(3);
                        showGame(game);
                        return true;
                    }
                }
            }
        } return false;
    }

    private static boolean finishMove(String[][] game, List<Integer> played) {
        if (game[0][0].equals("O") && game[0][1].equals("O")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("O") && game[0][2].equals("O")) {
            if (!played.contains(2)) {
                game[0][1] = "O";
                played.add(2);
                showGame(game);
                return true;
            }
        }
        if (game[0][1].equals("O") && game[0][2].equals("O")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("O") && game[1][1].equals("O")) {
            if (!played.contains(6)) {
                game[1][2] = "O";
                played.add(6);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("O") && game[1][2].equals("O")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("O") && game[1][2].equals("O")) {
            if (!played.contains(4)) {
                game[1][0] = "O";
                played.add(4);
                showGame(game);
                return true;
            }
        }
        if (game[2][0].equals("O") && game[2][1].equals("O")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[2][0].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(8)) {
                game[2][1] = "O";
                played.add(8);
                showGame(game);
                return true;
            }
        }
        if (game[2][1].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        //vertcals
        if (game[0][0].equals("O") && game[1][0].equals("O")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("O") && game[2][0].equals("O")) {
            if (!played.contains(4)) {
                game[1][0] = "O";
                played.add(4);
                showGame(game);
                return true;
            }
        }
        if (game[1][0].equals("O") && game[2][0].equals("O")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        //done
        if (game[0][1].equals("O") && game[1][1].equals("O")) {
            if (!played.contains(8)) {
                game[2][1] = "O";
                played.add(8);
                showGame(game);
                return true;
            }
        }
        if (game[0][1].equals("O") && game[2][1].equals("O")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("O") && game[2][1].equals("O")) {
            if (!played.contains(2)) {
                game[0][1] = "O";
                played.add(2);
                showGame(game);
                return true;
            }
        }
        //done
        if (game[0][2].equals("O") && game[1][2].equals("O")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[0][2].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(6)) {
                game[1][2] = "O";
                played.add(6);
                showGame(game);
                return true;
            }
        }
        if (game[1][2].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        //доне
        if (game[0][0].equals("O") && game[1][1].equals("O")) {
            if (!played.contains(9)) {
                game[2][2] = "O";
                played.add(9);
                showGame(game);
                return true;
            }
        }
        if (game[0][0].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("O") && game[2][2].equals("O")) {
            if (!played.contains(1)) {
                game[0][0] = "O";
                played.add(1);
                showGame(game);
                return true;
            }
        }
        //доне
        if (game[2][0].equals("O") && game[1][1].equals("O")) {
            if (!played.contains(3)) {
                game[0][2] = "O";
                played.add(3);
                showGame(game);
                return true;
            }
        }
        if (game[0][2].equals("O") && game[2][0].equals("O")) {
            if (!played.contains(5)) {
                game[1][1] = "O";
                played.add(5);
                showGame(game);
                return true;
            }
        }
        if (game[1][1].equals("O") && game[0][2].equals("O")) {
            if (!played.contains(7)) {
                game[2][0] = "O";
                played.add(7);
                showGame(game);
                return true;
            }
        }
        return false;

    }


    private static void playerMove(String[][] game, int move) {
        switch (move) {
            case 1:
                game[0][0] = "X";
                showGame(game);
                break;
            case 2:
                game[0][1] = "X";
                showGame(game);
                break;
            case 3:
                game[0][2] = "X";
                showGame(game);
                break;
            case 4:
                game[1][0] = "X";
                showGame(game);
                break;
            case 5:
                game[1][1] = "X";
                showGame(game);
                break;
            case 6:
                game[1][2] = "X";
                showGame(game);
                break;
            case 7:
                game[2][0] = "X";
                showGame(game);
                break;
            case 8:
                game[2][1] = "X";
                showGame(game);
                break;
            case 9:
                game[2][2] = "X";
                showGame(game);
                break;
            case 0:
                System.out.println("See squares and their numbers:");
                showInstructions();
                System.out.println("Lets continue..");
                showGame(game);
                break;
        }

    }

    private static void playWithFriend(String[][] game, String p1, String p2) {
        boolean isFinished = false;
        Scanner sc = new Scanner(System.in);
        int number = 0;
        List<Integer> played = new ArrayList<>();
        String name = "";
        boolean whoIsFirst = new Random().nextBoolean();
        while (!isFinished) {
            if (whoIsFirst) {
                name = played.size() % 2 == 0 ? p1 : p2;
            } else {
                name = played.size() % 2 == 0 ? p2 : p1;
            }
            System.err.println(name + " please make your move");
            number = sc.nextInt();
            if (!played.contains(number)) {
                if (number >= 0 && number <= 9) {
                    if (number != 0) {
                        played.add(number);
                    }
                } else {
                    System.out.println("Invalid input! Chose a number from 1 to 9 and 0 too see instructions.");
                    showGame(game);
                }
            } else {
                System.out.println("This square is taken. You have to move to another square");
                showGame(game);
                continue;
            }
            switch (number) {
                case 1:
                    if (played.size() % 2 == 0) {
                        game[0][0] = "X";
                    } else {
                        game[0][0] = "O";
                    }
                    showGame(game);
                    break;
                case 2:
                    if (played.size() % 2 == 0) {
                        game[0][1] = "X";
                    } else {
                        game[0][1] = "O";
                    }
                    showGame(game);
                    break;
                case 3:
                    if (played.size() % 2 == 0) {
                        game[0][2] = "X";
                    } else {
                        game[0][2] = "O";
                    }
                    showGame(game);
                    break;
                case 4:
                    if (played.size() % 2 == 0) {
                        game[1][0] = "X";
                    } else {
                        game[1][0] = "O";
                    }
                    showGame(game);
                    break;
                case 5:
                    if (played.size() % 2 == 0) {
                        game[1][1] = "X";
                    } else {
                        game[1][1] = "O";
                    }
                    showGame(game);
                    break;
                case 6:
                    if (played.size() % 2 == 0) {
                        game[1][2] = "X";
                    } else {
                        game[1][2] = "O";
                    }
                    showGame(game);
                    break;
                case 7:
                    if (played.size() % 2 == 0) {
                        game[2][0] = "X";
                    } else {
                        game[2][0] = "O";
                    }
                    showGame(game);
                    break;
                case 8:
                    if (played.size() % 2 == 0) {
                        game[2][1] = "X";
                    } else {
                        game[2][1] = "O";
                    }
                    showGame(game);
                    break;
                case 9:
                    if (played.size() % 2 == 0) {
                        game[2][2] = "X";
                    } else {
                        game[2][2] = "O";
                    }
                    showGame(game);
                    break;
                case 0:
                    System.out.println("See squares and their numbers:");
                    showInstructions();
                    System.out.println("Lets continue..");
                    showGame(game);
                    break;
            }
            if (played.size() >= 9) {
                System.out.println("Game over!");
                if (!gameChecker(game)) {
                    System.out.println("No winner, game is equal!");
                }
                return;
            }
            isFinished = gameChecker(game);
            if (isFinished) {
                System.out.println("Game over!");
                System.out.println("The winner is " + name);
            }
        }
//        showGame(game);
    }

    private static boolean gameChecker(String[][] game) {
        return checkFirstDiagonal(game)
                || checkSecondDiagonal(game)
                || checkVerticals(game)
                || checkHorizontals(game);

    }

    private static boolean checkHorizontals(String[][] game) {
        boolean firstVertical = game[0][0].equals("O") && game[0][1].equals("O")
                && game[0][2].equals("O");
        boolean secondVertical = game[1][0].equals("O") && game[1][1].equals("O")
                && game[1][2].equals("O");
        boolean thirdVertical = game[2][0].equals("O") && game[2][1].equals("O")
                && game[2][2].equals("O");

        boolean firstVertical1 = game[0][0].equals("X") && game[0][1].equals("X")
                && game[0][2].equals("X");
        boolean secondVertical2 = game[1][0].equals("X") && game[1][1].equals("X")
                && game[1][2].equals("X");
        boolean thirdVertical3 = game[2][0].equals("X") && game[2][1].equals("X")
                && game[2][2].equals("X");
        boolean isFinishedByO = firstVertical || secondVertical || thirdVertical;
        boolean isFinishedByX = firstVertical1 || secondVertical2 || thirdVertical3;
        return isFinishedByX || isFinishedByO;

    }

    private static boolean checkVerticals(String[][] game) {
        boolean firstVertical = game[0][0].equals("O") && game[1][0].equals("O")
                && game[2][0].equals("O");
        boolean secondVertical = game[0][1].equals("O") && game[1][1].equals("O")
                && game[2][1].equals("O");
        boolean thirdVertical = game[0][2].equals("O") && game[1][2].equals("O")
                && game[2][2].equals("O");

        boolean firstVertical1 = game[0][0].equals("X") && game[1][0].equals("X")
                && game[2][0].equals("X");
        boolean secondVertical2 = game[0][1].equals("X") && game[1][1].equals("X")
                && game[2][1].equals("X");
        boolean thirdVertical3 = game[0][2].equals("X") && game[1][2].equals("X")
                && game[2][2].equals("X");
        boolean isFinishedByO = firstVertical || secondVertical || thirdVertical;
        boolean isFinishedByX = firstVertical1 || secondVertical2 || thirdVertical3;
        return isFinishedByX || isFinishedByO;
    }

    private static boolean checkSecondDiagonal(String[][] game) {
        boolean isFinishedByO = true;
        boolean isFinishedByX = true;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (i + j == game.length - 1) {
                    if (!game[i][j].equals("O")) {
                        isFinishedByO = false;
                        break;
                    }
                }
            }
        }
        if (isFinishedByO == true) {
            return isFinishedByO;
        } else {
            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game[i].length; j++) {
                    if (i + j == game.length - 1) {
                        if (!game[i][j].equals("X")) {
                            isFinishedByX = false;
                            break;
                        }
                    }
                }
            }
        }
        return isFinishedByO || isFinishedByX;

    }

    private static boolean checkFirstDiagonal(String[][] game) {
        boolean isFinishedByO = true;
        boolean isFinishedByX = true;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (i == j) {
                    if (!game[i][j].equals("O")) {
                        isFinishedByO = false;
                        break;
                    }
                }
            }
        }
        if (isFinishedByO == true) {
            return isFinishedByO;
        } else {
            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game[i].length; j++) {
                    if (i == j) {
                        if (!game[i][j].equals("X")) {
                            isFinishedByX = false;
                            break;
                        }
                    }
                }
            }
        }
        return isFinishedByO || isFinishedByX;
    }

    //done
    public static void showInstructions() {
        int[][] game = new int[3][3];
        int number = 1;
        for (int i1 = 0; i1 < game.length; i1++) {
            for (int j = 0; j < game[i1].length; j++) {
                game[i1][j] = number++;
            }
        }

        for (int i = 0; i < game.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]);
                if (j != game[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

    //done
    public static void createGame(String[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = " ";
            }
        }
    }

    public static void showGame(String[][] game) {
        for (int i = 0; i < game.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]);
                if (j != game[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.print(" ]");
            System.out.println();
        }
    }
}
