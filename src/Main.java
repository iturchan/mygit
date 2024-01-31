import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char player1 = 'X';
        char player2 = '0';
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать в игру Крестики-Нолики GOTY edition!");
            System.out.println("Первый игрок ходит крестиками, второй ноликами");
            System.out.println("Введите имя первого игрока:");
            String playerName1 = sc.nextLine();
            System.out.println("Введите имя второго игрока:");
            String playerName2 = sc.nextLine();
            System.out.println("Для ввода координат хода используйте формат \"строка столбец\" (например \"1 2\") ");

            boolean turn = true; //true - первый игрок, false - второй игрок

            GameField.initBoard();
            GameField.printBoard();

            while (true) {
                char currentPlayer = turn ? player1 : player2;
                GameField.turner(currentPlayer);
                GameField.printBoard();
                if (GameField.winCheck(currentPlayer)) {
                    if (turn) {
                        System.out.println("Поздравляем, Игрок " + playerName1 + " победил!");
                    } else {
                        System.out.println("Поздравляем, Игрок " + playerName2 + " победил!");
                    }
                    break;
                }
                if (GameField.fullCheck()) {
                    System.out.println("Ничья!");
                    break;
                }
                turn = !turn;
            }
            if (!GameStart.restartGame()) {
                break;
            }
        }
    }
}