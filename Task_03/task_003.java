/*
    Реализовать простой калькулятор

    На вход поолучаем строку с простыой операцией,
    между цифровыми значениями и знаком операции должен быть пробел.
    Считаем введенные данные валидными, проверку верности данных и 
    математическое соответствие не проводим

*/

package Task_03;

import java.util.Scanner;

public class task_003 {

    public static void main(String[] args) {
        clearScreen();

        String calcStr = readStrConsole("Введите строку расчета: ");

        String[] calcs = calcStr.split(" ");

        float op1 = Float.parseFloat(calcs[0]);
        float op2 = Float.parseFloat(calcs[2]);
        float result = 0;

        switch (calcs[1]){
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
        }

        System.out.println(calcStr + " = " + result);
    }   
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String readStrConsole(String message){
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        return result;
    }
}
