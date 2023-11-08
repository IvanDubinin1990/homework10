import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String booksInfo = "";
    static int count;

    public static void main(String[] args) {

        while (true) {

            String name = inputBookName();
            int pageCount = inputPageCount();
            int priceBook = inputPrice();

            if (priceBook == 0 && pageCount == 0) {
                addBook(name);
            } else if (priceBook == 0) {
                addBook(name, pageCount);
            } else {
                addBook(name, pageCount, priceBook);
            }
            printInfo();

            int check = checkContinue();

            if (check == 2) {
                break;
            }
        }
    }

    public static String inputBookName() {
        count++;
        System.out.println("Введите название книги:");
        return count + ". " + new Scanner(System.in).nextLine();
    }

    public static int inputPageCount() {
        while (true) {
            try {
                System.out.println("Введите кол-во страниц:");
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException x) {
                System.out.println("Вы ввели не число.");
            }
        }
    }

    public static int inputPrice() {
        while (true) {
            try {
                System.out.println("Введите цену книги в рублях:");
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException x) {
                System.out.println("Вы ввели не число.");
            }
        }
    }

    public static void addBook(String bookName) {
        addBook(bookName, 0, 0);
    }

    public static void addBook(String bookName, int pageCount) {
        addBook(bookName, pageCount, 0);
    }

    public static void addBook(String bookName, int pageCount, int priceBook) {
        booksInfo = booksInfo + bookName + " - " + (pageCount > 0 ? pageCount : "N/A") + " стр., " + (priceBook > 0 ? priceBook : "N/A") + " р.\n";
    }

    public static void printInfo() {
        System.out.println(booksInfo);
    }

    public static int checkContinue() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Продолжить ввод? 1 - Да, 2 - Нет");
            try {
                int x = sc.nextInt();
                if (x == 1 || x == 2) {
                    return x;
                } else {
                    System.out.println("Вы ввели некорректную команду");
                }
            }catch (InputMismatchException x) {
                System.out.println("Вы ввели не число. Можно ввести только 1 или 2");
            }
        }
    }
}


