import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class solver {
    // scanner
    public static Scanner input = new Scanner(System.in);

    // main
    public static void main(String[] args) { 
        inputCard();
    }

    // menu
    public static void menu() {
        System.out.println("");
        System.out.println("     SELAMAT DATANG DI 24 GAME SOLVER     ");
        System.out.println("");
        System.out.println("Pilih jenis input");
        System.out.println("1. Keyboard");
        System.out.println("2. Random");
        System.out.print("Masukan pilihan: ");
    }


    // masukkan input 4 card
    public static void inputCard() {
        boolean flag;
        do {
            ArrayList<String> listCard = new ArrayList<String>();
            ArrayList<Integer> lc = new ArrayList<Integer>();
            flag = false;
            menu();
            String pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    listCard = inputKeyboard();
                    lc = strToInt(listCard);
                    // printCard(lc);
                    // int sum = solver24(lc);
                    // System.out.println(sum);
                    break;
                case "2": // masukkan input random
                    listCard = inputRandom();
                    lc = strToInt(listCard);
                    // printCard(lc);
                    // sum = solver24(lc);
                    // System.out.println(sum);
                    break; 
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
    }

    // masukkan input random
    public static ArrayList<String> inputRandom() {
        ArrayList<String> listCard = new ArrayList<String>();
        String[] card = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; 
        Random rand = new Random();

        System.out.println("");
        System.out.println("Kartu akan diacak secara random!");
        String s1 = card[rand.nextInt(card.length)];
        listCard.add(s1);
        String s2 = card[rand.nextInt(card.length)];
        listCard.add(s2);
        String s3 = card[rand.nextInt(card.length)];
        listCard.add(s3);
        String s4 = card[rand.nextInt(card.length)];
        listCard.add(s4);

        printCard(listCard);
        return listCard;
    }

    // masukkan input dari keyboard
    public static ArrayList<String> inputKeyboard() {
        ArrayList<String> listCard = new ArrayList<String>();

        System.out.println("");
        System.out.println("Masukkan 4 kartu: ");

        String s1 = input.nextLine();
        while (!validCard(s1)) {
            System.out.println("Input tidak valid! Masukkan lagi input.");
            s1 = input.nextLine();
        }
        listCard.add(s1);
        String s2 = input.nextLine();
        while (!validCard(s2)) {
            System.out.println("Input tidak valid! Masukkan lagi input.");
            s2 = input.nextLine();
        }
        listCard.add(s2);
        String s3 = input.nextLine();
        while (!validCard(s3)) {
            System.out.println("Input tidak valid! Masukkan lagi input.");
            s3 = input.nextLine();
        }
        listCard.add(s3);
        String s4 = input.nextLine();
        while (!validCard(s4)) {
            System.out.println("Input tidak valid! Masukkan lagi input.");
            s4 = input.nextLine();
        }
        listCard.add(s4);

        printCard(listCard);
        return listCard;
    }

    // print card
    public static void printCard(ArrayList listCard) {
        System.out.println("");
        for (int i = 0; i < listCard.size(); i++) { 		      
            System.out.print(listCard.get(i));
            System.out.print(" ");	
        }
        System.out.println("");
    }

    // memvalidasi kartu yang diperbolehkan
    public static boolean validCard(String s) {
        s = new String(s).intern();
        return ((s == "A") || (s == "J") || (s == "Q") || (s == "K") || (s == "2") || (s == "3") || (s == "4") || (s == "5") || (s == "6") || (s == "7") || (s == "8") || (s == "9") || (s == "10"));
    }

    // mengubah string ke integer
    public static ArrayList<Integer> strToInt(ArrayList<String> l) {
        ArrayList<Integer> lc = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i).intern();
            if (s == "A") {
                lc.add(1);
            }
            else if (s == "J") {
                lc.add(11);
            }
            else if (s == "Q") {
                lc.add(12);
            }
            else if (s == "K") {
                lc.add(13);
            }
            else {
                lc.add(Integer.parseInt(s));
            }
        }
        return lc;
    }
}