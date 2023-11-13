import java.util.Scanner;

class NumberReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String vstup = "";
            String vstupy;
            int intup = 0;
            int intupy;
            while (vstup == "" || intup <= 0) {
                System.out.println("Insert input file path || number of integers to input?");
                vstup = sc.nextLine();
                if (isInteger(vstup)) {
                        intup = Integer.parseInt(vstup);
                        if (intup <= 0) {
                            System.out.println("Number should be positive integer!");
                        } else {
                            System.out.println("Read from input " + intup + " numbers.");
                            NumberList list = new NumberList();
                            for (int i = 0; i < intup; i++) {
                                System.out.println(i + 1 + ". Number?");
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
                            System.out.println("For print left empty || for export insert output file path");
                            String vstup3 = sc.nextLine();
                            if (vstup3 != ""){
                                list.exportListToFile(vstup3);
                            } else {
                                list.printList();
                            }
                        }
                } else  if (isDouble(vstup)) {
                    System.out.println("Number should be positive integer!");
                } else {
                    NumberList list = new NumberList();
                    list.importListFromFile(vstup);
                    if (list != null) {
                        intup++;
                        System.out.println("For print left empty || for export insert output file path");
                        String vstup2 = sc.nextLine();
                        if (vstup2 != ""){
                            list.exportListToFile(vstup2);
                        } else {
                            list.printList();
                        }
                    }
                }
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
