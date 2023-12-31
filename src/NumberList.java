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
            } if (!list.isEmpty()) System.out.println("File successfully imported!");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    public void exportListToFile(String outputFile) {
        File file = new File(outputFile);
        try (PrintWriter outputWriter =
                     new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
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
            } outputWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File successfully exported!");
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
    public int getSize(){ return list.size();
    }
}