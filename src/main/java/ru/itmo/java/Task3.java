package ru.itmo.java;

import javax.swing.*;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0))
            return new int[]{};
        else
        {
            int x = inputArray[inputArray.length - 1];

            for (int i = inputArray.length - 1; i > 0; i--)
                inputArray[i] = inputArray[i - 1];

            inputArray[0] = x;

            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0))
            return 0;

        if (inputArray.length == 1)
            return inputArray[0];
        else {
            for (int i = 0; i < inputArray.length - 1; i++)
                for (int j = i + 1; j < inputArray.length; j++)
                    if (inputArray[i] < inputArray[j]) {
                        int x = inputArray[i];
                        inputArray[i] = inputArray[j];
                        inputArray[j] = x;
                    }

            return inputArray[0] * inputArray[1];
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if ((input == null) || (input.length() == 0))
            return 0;

        int x = 0;

        for (int i = 0; i < input.length(); i++)
            if ((input.charAt(i) == 'a') || (input.charAt(i) == 'b') || (input.charAt(i) == 'A') || (input.charAt(i) == 'B'))
                x++;

        return (int)Math.floor((x / (double)input.length()) * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;

        boolean flag = true;

        for (int i = 0; i < input.length() / 2; i++)
            if (input.charAt(i) != input.charAt(input.length() - (i + 1)))
                flag = false;

        return flag;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if ((input == null) || (input.length() == 0))
            return new String();
        String s = new String();
        char c = input.charAt(0);
        int x = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != c) {
                s += c + Inttostr(x);
                c = input.charAt(i);
                x = 1;
            } else
                x++;
        }

        s += c + Inttostr(x);

        return s;
    }

    static String Inttostr (int x)
    {
        String s = new String();

        while (x > 0)
        {
            s += (char)( (x %10) + '0');
            x /= 10;
        }

        return s;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if ((one == null) || (one.length() == 0))
            return false;

        if ((two == null) || (two.length() == 0))
            return false;


        int[] n1 = new int[70000];
        int[] n2 = new int[70000];

        for (int i = 0; i < one.length(); i++)
            n1[one.charAt(i)]++;

        for (int i = 0; i < two.length(); i++)
            n2[two.charAt(i)]++;

        boolean flag = true;

        for (int i = 0; i < 70000; i++)
            if (n1[i] != n2[i])
                flag = false;

        return flag;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if ((s == null) || (s.length() == 0))
            return false;

        int[] n = new int[70000];

        for (int i = 0; i < s.length(); i++)
            n[s.charAt(i)]++;

        boolean flag = true;

        for (int i = 0; i < 70000; i++)
            if (n[i] > 1)
                flag = false;

        return flag;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null)
            return null;

        for (int i = 0; i < m.length; i++)
            for (int j = i; j < m.length; j++)
            {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if ((inputStrings == null) || (inputStrings.length == 0))
            return new String();
        else if (separator == null)
            separator = ' ';
        String S = new String();
        S += inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++)
        {
            S += separator + inputStrings[i];
        }

        return S;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if ((inputStrings == null) || (inputStrings.length == 0) || (prefix == null))
            return 0;
        else
        {
            int k = 0;
            for (int i = 0; i < inputStrings.length; i++)
                if (inputStrings[i].startsWith(prefix))
                    k++;
            return k;
        }
    }
}
