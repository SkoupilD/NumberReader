import java.io.File;
import java.util.Scanner;

class NumberReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String vstup = "";
            String vstupy;
            int intup = 0;
            int intupy;
            NumberList list = new NumberList();
            while (vstup.isEmpty() || intup <= 0 || list.getSize() <= 0) {
                System.out.println("\"Insert input file path\" || \"Insert number of integers to input\"");
                vstup = sc.nextLine();
                if (isInteger(vstup)) {
                        intup = Integer.parseInt(vstup);
                        if (intup <= 0) {
                            System.out.println("Number should be positive integer!");
                        } else {
                            System.out.println("Reading from input " + intup + " numbers...");
                            for (int i = 0; i < intup; i++) {
                                System.out.print("\"Insert ");
                                System.out.println(i + 1 + ".number\"");
                                vstupy = sc.nextLine();
                                if (isInteger(vstupy)){
                                    intupy = Integer.parseInt(vstupy);
                                    if (intupy > 0){
                                        list.addNumber(intupy);
                                    } else {
                                        System.out.println("Number should be positive integer!");
                                        i--;
                                    }
                                } else {
                                    System.out.println("Number should be positive integer!");
                                    i--;
                                }
                            }
                        }
                } else  if (isDouble(vstup)) {
                    System.out.println("Number should be positive integer!");
                } else {
                    list.importListFromFile(vstup);
                    if (list.getSize() > 0) {
                        intup++;
                    }
                }
            }
        System.out.println("\"For print left empty\" || \"For export insert output file path\"");
        String vstup2 = sc.nextLine();
        if (!vstup2.isEmpty()){
            File file = new File(vstup2);
            if (file.exists()) {list.exportListToFile(vstup2);}
            else {
                while (!file.exists()){
                System.out.println("File not found!");
                    System.out.println("\"For print left empty\" || \"For export insert output file path\"");
                vstup2 = sc.nextLine();
                file = new File(vstup2);
                if (vstup2.isEmpty()){
                    list.printList();
                    break;
                }
                }
            }
        } else {
            list.printList();
        }
    }
    public static boolean isInteger (String str){
        if (str == null) {
            return false;
        }
        return str.matches("-?\\d+");
    }
    public static boolean isDouble(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
