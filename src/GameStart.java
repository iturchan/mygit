import java.util.Scanner;

public class GameStart {
    public static boolean restartGame(){
        System.out.println("Хотите сыграть ещё? (Введите: да или нет)");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().toLowerCase();
        if (a.equals("да")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            return true;
        }
        else if (a.equals("нет")) {
            System.out.println("Спасибо за игру!");
            System.out.print("Нажмите \"Enter\" для завершения работы программы ...");
            sc.nextLine();
            return false;
        }
        else {
            System.out.print("Неверный формат ввода, ты безнадёжно туп. Игра закончена...");
            System.out.print("Спасибо за игру! Нажмите \"Enter\" для завершения работы программы ...");
            return false;
        }
    }
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
            if (!restartGame()) {
                break;
            }
        }
    }
}