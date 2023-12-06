import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        System.out.println(parseInputFile("/home/seba/workspace/Advent-of-code-2023/01/input1.txt"));
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
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int firstIndex = -1;
        int lastIndex = -1;
        int first = -1;
        int last = -1;
        for (int i = 0; i < numbers.length; i++) {
            int idx = line.indexOf(numbers[i]);

            if (idx >= 0 && firstIndex < 0 || idx < firstIndex) {
                firstIndex = idx;
                first = i;
            }

            idx = line.lastIndexOf(numbers[i]);

            if (idx >= 0 && lastIndex < 0 || idx > lastIndex) {
                lastIndex = idx;
                last = i;
            }

            idx = line.indexOf(String.valueOf(i));

            if (idx >= 0 && firstIndex < 0 || idx < firstIndex) {
                firstIndex = idx;
                first = i;
            }

            idx = line.lastIndexOf(String.valueOf(i));
            if (idx >= 0 && lastIndex < 0 || idx > lastIndex) {
                lastIndex = idx;
                last = i;
            }

        }
        System.out.println(String.format("%d%d", first, last));
        if (first < 0 && last < 0)
            return 0;

        return Integer.parseInt(String.format("%d%d", first, last));
    }

}