import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        System.out.println(parseInputFile("/home/seba/workspace/AOF2023/01/input1.txt"));
    }

    public static int parseInputFile(String fileName) {
        int result = 0;
        File inFile = new File(fileName);
        try (Scanner sc = new Scanner(inFile)) {
            while (sc.hasNextLine()) {
                result += getNumber(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static int getNumber(String line) {
        char first = 'n';
        char last = 'n';
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                if (first == 'n') {
                    first = c;
                    last = c;
                    continue;
                }
                last = c;
            }
        }
        // System.out.print(new String(new char[]{first, last}));
        return Integer.parseInt(new String(new char[] { first, last }));
    }
}