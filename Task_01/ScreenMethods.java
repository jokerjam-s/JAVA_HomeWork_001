import java.util.Scanner;

public class ScreenMethods {
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int readIntConsole(String message){
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        return result;
    }
}