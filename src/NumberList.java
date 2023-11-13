import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class NumberList {
    private ArrayList<Integer> list = new ArrayList<>();

    public void importListFromFile(String inputFile) {
        try {
            File myFile = new File(inputFile);
            Scanner sc = new Scanner(myFile);
            int record;
            while (sc.hasNextInt()) {
                record = Integer.parseInt(sc.nextLine());
                if (record > 0) {
                list.add(record);
            }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    public void exportListToFile(String outputFile) {

        try (PrintWriter outputWriter =
                     new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
            int size = list.size();
            if (size % 2 == 0) {
                for (int number : list) {
                    if (number % 2 == 0) {
                        outputWriter.println(number);
                    }
                }
            } else {
                for (int number : list) {
                    if (number % 2 != 0) {
                        outputWriter.println(number);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void printList() {
        int size = list.size();
        if (size % 2 == 0) {
            for (int number : list) {
                if (number % 2 == 0) {
                    System.out.println("Even number: " + number);
                }
            }
        } else {
            for (int number : list) {
                if (number % 2 != 0) {
                    System.out.println("Odd number: " + number);
                }
            }
        }
    }
    public void addNumber(int i) {
        list.add(i);
    }

}