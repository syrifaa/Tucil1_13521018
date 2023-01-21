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
                    int sum = solver24(lc);
                    System.out.println(sum);
                    break;
                case "2": // masukkan input random
                    listCard = inputRandom();
                    lc = strToInt(listCard);
                    // printCard(lc);
                    sum = solver24(lc);
                    System.out.println(sum);
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

    public static Double operator(Double card1, Double card2, int op) {
        Double result = 0.0;
        if (op == 0) {
            result = (card1 + card2);
        }
        else if (op == 1) {
            result = (card1 - card2);
        } 
        else if (op == 2) {
            result = (card1 * card2);
        }
        else if (op == 3) {
            result = (card1 / card2);
        }
        return result;
    }

    public static String operatorStr(int card1, int card2, int op) {
        String result  = "";
        String cardStr1 = Integer.toString(card1);
        String cardStr2 = Integer.toString(card2);
        if (op == 0) {
            result = "(" + cardStr1 + " + " + cardStr2 + ")";
        }
        else if (op == 1) {
            result = "(" + cardStr1 + " - " + cardStr2 + ")";
        } 
        else if (op == 2) {
            result = "(" + cardStr1 + " * " + cardStr2 + ")";
        }
        else if (op == 3) {
            result = "(" + cardStr1 + " / " + cardStr2 + ")";
        }
        return result;
    }

    public static String operatorStr2(String card1, int card2, int op) {
        String result  = "";
        String cardStr2 = Integer.toString(card2);
        if (op == 0) {
            result = "(" + card1 + " + " + cardStr2 + ")";
        }
        else if (op == 1) {
            result = "(" + card1 + " - " + cardStr2 + ")";
        } 
        else if (op == 2) {
            result = "(" + card1 + " * " + cardStr2 + ")";
        }
        else if (op == 3) {
            result = "(" + card1 + "/" + cardStr2 + ")";
        }
        return result;
    }

    public static String operatorStr3(int card1, String card2, int op) {
        String result  = "";
        String cardStr1 = Integer.toString(card1);
        if (op == 0) {
            result = "(" + cardStr1 + " + " + card2 + ")";
        }
        else if (op == 1) {
            result = "(" + cardStr1 + " - " + card2 + ")";
        } 
        else if (op == 2) {
            result = "(" + cardStr1 + " * " + card2 + ")";
        }
        else if (op == 3) {
            result = "(" + cardStr1 + "/" + card2 + ")";
        }
        return result;
    }

    public static String operatorStr4(String card1, String card2, int op) {
        String result  = "";
        if (op == 0) {
            result = "(" + card1 + " + " + card2 + ")";
        }
        else if (op == 1) {
            result = "(" + card1 + " - " + card2 + ")";
        } 
        else if (op == 2) {
            result = "(" + card1 + " * " + card2 + ")";
        }
        else if (op == 3) {
            result = "(" + card1 + "/" + card2 + ")";
        }
        return result;
    }

    public static int solver24(ArrayList<Integer> lc) {
        int sum = 0;

        Double[] lCard = new Double[lc.size()];
        for (int i = 0; i < lc.size(); i++) {
            lCard[i] = (double) lc.get(i);
        }

        Double result1 = 0.0;
        Double result2 = 0.0;
        Double result3 = 0.0;
        Double result4 = 0.0;
        String resultStr = "";
        for (int i = 0; i < lc.size(); i++) {
            for (int j = 0; j < lc.size(); j++) {
                for (int k = 0; k < lc.size(); k++) {
                    for (int l = 0; l < lc.size(); l++) {
                        for (int a = 0; a < 4; a++) {
                            for (int b = 0; b < 4; b++) {
                                for (int c = 0; c < 4; c++) {
                                    if ((i != j) && (i != k) && (i != l) && (j != k) && (j != l) && (k != l)) {

                                        // ((lCard[i] .. lCard[j]) .. lCard[k]) .. lCard[l]
                                        result1 = operator(operator(operator(lCard[i], lCard[j], a), lCard[k], b), lCard[l], c);
                                        if (result1 == 24.00) {
                                            sum += 1;
                                            resultStr = operatorStr2(operatorStr2(operatorStr(lc.get(i), lc.get(j), a), lc.get(k), b), lc.get(l), c);
                                            System.out.println(resultStr);
                                        }

                                        // (lCard[i] .. (lCard[j] .. lCard[k])) .. lCard[l]
                                        result2 = operator(operator(lCard[i], operator(lCard[j], lCard[k], b), a), lCard[l], c);
                                        if (result2 == 24.00) {
                                            sum += 1;
                                            resultStr = operatorStr2(operatorStr3(lc.get(i), operatorStr(lc.get(j), lc.get(k), b), a), lc.get(l), c);
                                            System.out.println(resultStr);
                                        }

                                        // (lCard[i] .. lCard[j]) .. (lCard[k]) .. lCard[l])
                                        result3 = operator((operator(lCard[i],lCard[j],a)),(operator(lCard[k],lCard[l],c)),b);
                                        if (result3 == 24.00) {
                                            sum += 1;
                                            resultStr = operatorStr4((operatorStr(lc.get(i),lc.get(j),a)),(operatorStr(lc.get(k),lc.get(l),c)),b);
                                            System.out.println(resultStr);
                                        }

                                        // lCard[i] .. ((lCard[j]) .. lCard[k]) .. lCard[l])
                                        result4 = operator(lCard[i], operator(operator(lCard[j], lCard[k], b), lCard[l], c), a);
                                        if (result4 == 24.00) {
                                            sum += 1;
                                            resultStr = operatorStr3(lc.get(i), operatorStr2(operatorStr(lc.get(j), lc.get(k), b), lc.get(l), c), a);
                                            System.out.println(resultStr);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }
}