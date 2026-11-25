import java.util.Scanner;

/**
 * Завдання 9: знайти всі досконалі числа в діапазоні від 1 до заданого додатного числа.
 * Досконале число дорівнює сумі всіх своїх дільників, крім самого себе (наприклад, 6 = 1 + 2 + 3).
 */
public class Main {

    /** Сума дільників числа, крім самого числа. Перебір до кореня: кожен дільник d має пару number / d. */
    private static int sumOfProperDivisors(int number) {
        int sum = 1;
        for (int d = 2; (long) d * d <= number; d++) {
            if (number % d == 0) {
                sum += d;
                int pair = number / d;
                if (pair != d) {
                    sum += pair;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть додатне ціле число n: ");
        int n = in.nextInt();
        if (n < 1) {
            System.out.println("Число має бути додатним.");
            return;
        }

        System.out.println("Досконалі числа в діапазоні [1; " + n + "]:");
        boolean found = false;
        for (int number = 2; number <= n; number++) {
            if (sumOfProperDivisors(number) == number) {
                System.out.println(number);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Не знайдено.");
        }
    }
}
