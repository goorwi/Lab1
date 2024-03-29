import java.util.*;
import java.util.Scanner;

import static java.util.Map.entry;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Map<String, String> dictionary = Map.ofEntries(
            entry("а","a"),
            entry("б","b"),
            entry("в","v"),
            entry("г","g"),
            entry("д","d"),
            entry("е","e"),
            entry("ё","e"),
            entry("ж","zh"),
            entry("з","z"),
            entry("и","i"),
            entry("й","i"),
            entry("к","k"),
            entry("л","l"),
            entry("м","m"),
            entry("н","n"),
            entry("о","o"),
            entry("п","p"),
            entry("р","r"),
            entry("с","s"),
            entry("т","t"),
            entry("у","u"),
            entry("ф","f"),
            entry("х","h"),
            entry("ц","c"),
            entry("ч","ch"),
            entry("ш","sh"),
            entry("щ","sh'"),
            entry("ъ",""),
            entry("ы","i"),
            entry("ь",""),
            entry("э","e"),
            entry("ю","yu"),
            entry("я","ya")
    );
    public static void main(String[] args) {
        int choice = 0;

        while (choice != 4)
        {
            choice = menu();
            if (choice == 0) break;
            while (choice == Integer.MIN_VALUE) {
                System.out.println("Введите корректный номер задания!");
                System.out.println("---------------------------------");
                choice = menu();
            }

            Scanner input = new Scanner(System.in);
            switch (choice){
                case 1:{
                    int c = 0;
                    while (c == 0) {
                        first();
                        System.out.println("Покинуть задание? (1-да, 0-нет)");
                        c = input.nextInt();
                        input.nextLine();
                        while (c != 1 && c != 0) {
                            c = input.nextInt();
                            input.nextLine();
                        }
                    }
                    break;
                }
                case 2:{
                    int c = 0;
                    while (c == 0) {
                        second();
                        System.out.println("Покинуть задание? (1-да, 0-нет)");
                        c = input.nextInt();
                        input.nextLine();
                        while (c != 1 && c != 0) {
                            c = input.nextInt();
                            input.nextLine();
                        }
                    }
                    break;
                }
                case 3:{
                    third(0,"");
                    break;
                }
            }
        }
    }

    public static void first()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите способ:\n" +
                "1) Вывести примеры предложений\n" +
                "2) Ввести предложения вручную");
        System.out.print("Способ №");
        int selection = input.nextInt();
        input.nextLine();

        if (selection == 1){
            System.out.println("Транслитерация предложения \"Иван Иванов\": " + transliteration("Иван Иванов"));
            System.out.println("Транслитерация предложения \"Иванов John\": " + transliteration("Иванов John", "_"));
            System.out.println("Транслитерация предложения \"Жанна Д'арк\": " + transliteration("Жанна Д'арк"));
            System.out.println("Транслитерация предложения \"Муртузаев Тельман Ислам оглы\": " + transliteration("Муртузаев Тельман Ислам оглы"));
            System.out.println("Транслитерация предложения \"Анна-Мария-Антуаннета II\": " + transliteration("Анна-Мария-Антуаннета II"));
            System.out.println("Транслитерация предложения \"Шишкина Яна\": " + transliteration("Шишкина Яна"));
        }
        else if (selection == 2) {
            System.out.print("Введите предложение: ");
            String str = input.nextLine();
            System.out.print("Введите строку-разделитель: ");
            String divider = input.nextLine();
            if (divider.isEmpty()) System.out.println("Транслитерация предложения \"" + str + "\": " + transliteration(str));
            else System.out.println("Транслитерация предложения \"" + str + "\": " + transliteration(str, divider));
        }
        System.out.println("---------------------------------");
    }
    public static void second()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите способ:\n" +
                "1) Вывести примеры предложений\n" +
                "2) Ввести предложения вручную");
        System.out.print("Способ №");
        int selection = input.nextInt();
        input.nextLine();
        if (selection == 1){
            System.out.println("Предложение \"39 новых фич, которые будут доступны в Java 12\" усечено до 16 символов: " + truncate("39 новых фич, которые будут доступны в Java 12"));
            System.out.println("Предложение \"39 новых фич, которые будут доступны в Java 12\" усечено до 9 символов: " + truncate("39 новых фич, которые будут доступны в Java 12", 9));
            System.out.println("Предложение \"A   а  \" усечено до 3 символов: " + truncate("A   а  ", 3));
            System.out.println("Предложение \"A     \" усечено до 3 символов: " + truncate("A     ", 3));
        }
        else {
            System.out.print("Введите предложение: ");
            String str = input.nextLine();
            System.out.print("Введите конечное число символов: ");
            int quantity = input.nextInt();
            input.nextLine();
            if (quantity == 0) System.out.println("Предложение \"" + str + "\" усечено до 16 символов: " + truncate(str));
            else System.out.println("Предложение \"" + str + "\" усечено до " + quantity + " символов: " + truncate(str, quantity));
        }
        System.out.println("---------------------------------");
    }
    public static void third(int flag, String str)
    {
        int selection;
        Scanner input = new Scanner(System.in);
        if (flag == 0) {
            System.out.println("Выберите способ:\n" +
                    "1) Вывести примеры предложений\n" +
                    "2) Ввести предложения вручную");
            System.out.print("Способ №");
            selection = input.nextInt();
            input.nextLine();
        }
        else selection = 2;
        if (selection == 1){
            Sentenceable s;
            s = Caser.ModeOfText(1);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"кАк в. преДложенИи\"");
            System.out.println("Результат: " + s.change("кАк в. преДложенИи"));
            s = Caser.ModeOfText(2);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"Все стрОчнЫе\"");
            System.out.println("Результат: " + s.change("Все стрОчнЫе"));
            s = Caser.ModeOfText(3);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"все ПрописНые\"");
            System.out.println("Результат: " + s.change("все ПрописНые"));
            s = Caser.ModeOfText(4);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"НачинАть c проПисНыХ\"");
            System.out.println("Результат: " + s.change("НачинАть c проПисНыХ"));
            s = Caser.ModeOfText(5);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"Изменить РегиСтр\"");
            System.out.println("Результат: " + s.change("Изменить РегиСтр"));

        }
        else {
            if (flag == 2 || flag == 0) {
                System.out.print("Введите предложение: ");
                str = input.nextLine();
            }
            System.out.println("Выберите способ записи: \n" +
                    "1) Как в предложении\n" +
                    "2) все строчные\n" +
                    "3) ВСЕ ПРОПИСНЫЕ\n" +
                    "4) Начинать С Прописных\n" +
                    "5) иЗМЕНИТЬ РЕГИСТР");
            System.out.print("Способ №");
            int method = input.nextInt();
            input.nextLine();
            Sentenceable s;
            s = Caser.ModeOfText(method);
            System.out.println("---------------------------------");
            System.out.println("Начальный вариант записи: \"" + str + "\"");
            System.out.println("Результат: " + s.change(str));
        }
        System.out.println("---------------------------------\n");

        System.out.println("Выберите дальнейшие действия:\n" +
                "1) Оставить предложение\n" +
                "2) Изменить предложение\n" +
                "0) Покинуть задание");
        int c = input.nextInt();
        input.nextLine();
        if (selection == 1 && (c == 1 || c == 2)) third(2, "");
        else {
            if (c == 1) third(1, str);
            else if (c == 2) third(2, str);
        }
        if (flag == 0) System.out.println("---------------------------------\n");
    }
    public static int menu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите номер задания\n" +
                "---------------------------------\n" +
                "1) Транслитерация\n" +
                "2) Обрезать предложение\n" +
                "3) Смена регистра\n" +
                "0) Выход из программы\n" +
                "---------------------------------");
        System.out.print("Задание №");
        int selection = input.nextInt();
        input.nextLine();
        if (selection != 1 && selection != 2 && selection != 3 && selection != 0) selection = Integer.MIN_VALUE;
        System.out.println("---------------------------------");
        return selection;
    }
    public static String transliteration(String str, String divider)
    {
        StringBuffer test = new StringBuffer(str);
        for (int i = 0; i < test.length(); i++) {
            if (dictionary.containsKey(test.substring(i,i+1)))
                test.replace(i, i + 1, dictionary.get(test.substring(i, i + 1)));
            else if (dictionary.containsKey(test.substring(i,i+1).toLowerCase())) {
                test.replace(i, i + 1, dictionary.get(test.substring(i, i + 1).toLowerCase()).toUpperCase());
                if (Character.isUpperCase(test.charAt(i+1)))
                    test.replace(i+1, i + 2, test.substring(i+1, i + 2).toLowerCase());
            }
            else if (test.substring(i,i+1).equals(" "))
                test.replace(i, i + 1, divider);
        }
        return test.toString();
    }
    public static String transliteration(String str)
    {
        return transliteration(str, " ");
    }
    public static String truncate(String str, Integer quantity)
    {
        String filler = "...";

        boolean ok = false;
        StringBuilder test = new StringBuilder(str);
        if (test.length() > quantity)
        {
            String t = " ";
            t = t.repeat(test.length() - quantity);
            if (!test.substring(quantity, test.length()).contentEquals(t)) {
                test.replace(quantity, test.length(), "");
                ok = true;
            }
        }
        if (ok)
        {
            test = new StringBuilder(test.toString().trim());
            if (test.substring(test.length() - 1, test.length()).equals(" "))
                test.replace(test.length() - 1, test.length(), filler);
            else test.append(filler);
        }

        return test.toString();
    }
    public static String truncate(String str)
    {
        return truncate(str, 16);
    }


}