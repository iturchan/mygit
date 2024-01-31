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
}