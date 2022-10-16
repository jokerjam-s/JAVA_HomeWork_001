/* 
    +Задано уравнение вида q + w = e, q, w, e >= 0.
    Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
    Требуется восстановить выражение до верного равенства. 
    Предложить хотя бы одно решение или сообщить, что его нет.

    Работаем только с положительными целыми числами 
 */

package Task_04;

import java.util.Scanner;

public class task_004 {
    public static void main(String[] args) {

        clearScreen();

        String q = readStrConsole("Введите q: ");
        String w = readStrConsole("Введите w: ");
        String e = readStrConsole("Введите e: ");

        String result = "";

        // Проверить длину введенных значениий.
        // Например, если среди слагаемых есть трехзначное число, а результат -
        // двузначное,
        // имеем неверное выражение
        if (q.length() > e.length() || w.length() > e.length()) {
            result = "Неверное выражение";
        } else {
            // разложение чисел на разряды
            // + дополнительный разряд, на случай переполнения при расчетах
            int[] qr = digToArray(q, e.length()+1);
            int[] wr = digToArray(w, e.length()+1);
            int[] er = digToArray(e, e.length()+1);

            // поиск неизвестных
            for (int i = er.length - 1; i > 0; i--) {
                int d = qr[i] < 0 ? wr[i] : qr[i];
                if (er[i] >= d) {
                    if (qr[i] < 0)
                        qr[i] = er[i] - d;
                    if (wr[i] < 0)
                        wr[i] = er[i] - d;
                } else {
                    er[i - 1]--;
                    er[i] += 10;

                    if (qr[i] < 0)
                        qr[i] = er[i] - d;
                    if (wr[i] < 0)
                        wr[i] = er[i] - d;
                }
            }

            // собираем ответ проверяем решение
            int Q = arrayToDig(qr);
            int W = arrayToDig(wr);
            int E = Integer.parseInt(e);

            if ((Q + W) == E) {
                StringBuffer sb = new StringBuffer();
                sb.append(Q);
                sb.append(" + ");
                sb.append(W);
                sb.append(" = ");
                sb.append(E);

                result = sb.toString();
            } else {
                result = "решение не найдено";
            }

        }

        System.out.println(result);
    }

    public static int arrayToDig(int[] arr) {
        int result = 0;
        int mult = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            result += arr[i] * mult;
            mult *= 10;
        }
        return result;
    }

    // получение поразрядного представления числа
    // (? заменяем на -1, т.к. в выражение ищем только для положительных чисел)
    public static int[] digToArray(String dig, int lenArr) {
        int[] arr = new int[lenArr];
        char[] strk = dig.toCharArray();

        int posStr = strk.length - 1;
        int posArr = lenArr - 1;

        while (posStr >= 0) {
            if (Character.isDigit(strk[posStr])) {
                arr[posArr] = Integer.parseInt(String.valueOf(strk[posStr]));
            } else {
                arr[posArr] = -1;
            }
            posArr--;
            posStr--;
        }

        return arr;
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение строкового значения с консоли
    public static String readStrConsole(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        return result;
    }
}
