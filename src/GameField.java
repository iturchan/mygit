import java.lang.reflect.Field;
import java.util.Scanner;
public class GameField {
    public static char[][] board;
    public static int size = 3;
        public static void initBoard () {
            board = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    board[i][j] = ' ';
                }
            }
        }
        public static void printBoard () {
            System.out.println("    1   2   3");
            System.out.println("  +---+---+---+");
            for (int i = 0; i < size; i++) {
                System.out.print(i + 1 + " |");
                for (int j = 0; j < size; j++) {
                    System.out.print(" " + board[i][j] + " |");
                }
                System.out.println();
                System.out.println("  +---+---+---+");
            }
        }

    public static void turner(char symbol) {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        System.out.println("Ходят " + symbol);
        while (true){
            System.out.print("Введите координаты хода в формате \"строка столбец\": ");
            if (sc.hasNextInt()) {
                row = sc.nextInt() - 1;
                if (sc.hasNextInt()) {
                    col = sc.nextInt() - 1;
                } else {
                    sc.nextLine();
                    System.out.println("Какой же ты тупой... Неверный формат ввода, введите два целых числа от 1 до 3");
                    continue;
                }
            } else {
                sc.nextLine();
                System.out.println("Какой же ты тупой... Неверный формат ввода, введите два целых числа от 1 до 3");
                continue;
            }
            if (row<0 || row>size-1 || col<0 || col>size-1){
                System.out.println("Какой же ты чушпан... Неверные координаты, введите два целых числа от 1 до 3");
                continue;
            }
            if (board[row][col] != ' '){
                System.out.println("Какой же ты идиот... Клетка уже занята! Выберите другую клетку!");
                continue;
            }
            break;
        }
        board[row][col] = symbol;
    }
    public static boolean winCheck(char symbol){
        for (int i = 0; i < size; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;

            }
        }
        for (int i = 0; i < size; i++) {
            if (board[0][i] == symbol && board [1][i] == symbol && board [2][i] == symbol){
                return true;
            }
        }
        if (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol){
            return true;
        }
        if (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol){
            return true;
        }
        return false;
    }
    public static boolean fullCheck(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ( board[i][j] != ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
