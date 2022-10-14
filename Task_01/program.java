/*
 * 
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 *
 */

import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        clearScreen();
        int N = readIntConsole("Введите N: ");
        
        System.out.printf("Треугольное число: %d", calc_trangle_digit(N));

    }

    public static int calc_trangle_digit(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

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
