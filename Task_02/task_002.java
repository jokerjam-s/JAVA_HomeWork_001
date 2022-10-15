/*

Вывести все простые числа от 1 до 1000
поиск через решето Аткина

*/

package Task_02;

import java.util.Scanner;

public class task_002 {
    public static void main(String[] args) {
        final int finish = 1000;

        final int limit = (int) Math.sqrt(finish);

        boolean[] is_prime = new boolean[finish + 1];

        for (int i = 0; i <= finish; i++) {
            is_prime[i] = false;
        }

        is_prime[2] = is_prime[3] = true;

        // Предположительно простые — это целые с нечётным числом
        // представлений в данных квадратных формах.
        // x2 и y2 — это квадраты i и j (оптимизация).
        int x2 = 0;
        for (int i = 1; i <= limit; ++i) {
            x2 += 2 * i - 1;
            int y2 = 0;
            for (int j = 1; j <= limit; ++j) {
                y2 += 2 * j - 1;

                int n = 4 * x2 + y2;
                if ((n <= finish) && (n % 12 == 1 || n % 12 == 5))
                    is_prime[n] = !is_prime[n];

                // n = 3 * x2 + y2;
                n -= x2; // Оптимизация
                if ((n <= finish) && (n % 12 == 7))
                    is_prime[n] = !is_prime[n];

                // n = 3 * x2 - y2;
                n -= 2 * y2; // Оптимизация
                if ((i > j) && (n <= finish) && (n % 12 == 11))
                    is_prime[n] = !is_prime[n];
            }
        }

        // Отсеиваем кратные квадратам простых чисел в интервале [5, sqrt(limit)].
        // (основной этап не может их отсеять)
        for (int i = 5; i <= limit; ++i) {
            if (is_prime[i]) {
                int n = i * i;
                for (int j = n; j <= finish; j += n)
                    is_prime[j] = false;
            }
        }

        clearScreen();

        // Вывод списка простых чисел в консоль.
        System.out.print("2 3 5");
        for (int i = 6; i <= finish; ++i) { // добавлена проверка делимости на 3 и 5. В оригинальной версии алгоритма
                                           // потребности в ней нет.
            if ((is_prime[i]) && (i % 3 != 0) && (i % 5 != 0))
                System.out.printf(" %d", i);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
