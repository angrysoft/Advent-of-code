package Day01;
import java.io.File;
import java.io.FileNotFoundException;
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
            int fidx = line.indexOf(numbers[i]);
            int lidx = line.lastIndexOf(numbers[i]);
            if (fidx >= 0) {
                if (firstIndex < 0 || firstIndex > fidx) {
                    firstIndex = fidx;
                    first = i;
                }
            }

            if (lidx >= 0) {
                if (lastIndex < 0 || lastIndex < lidx) {
                    lastIndex = lidx;
                    last = i;
                }
            }

            fidx = line.indexOf(String.valueOf(i));
            lidx = line.lastIndexOf(String.valueOf(i));
            if (fidx >= 0) {
                if (firstIndex < 0 || firstIndex > fidx) {
                    firstIndex = fidx;
                    first = i;
                }
            }

            if (lidx >= 0) {
                if (lastIndex < 0 || lastIndex < lidx) {
                    lastIndex = lidx;
                    last = i;
                }
            }
        }

        if (first < 0 && last < 0)
            return 0;

        return Integer.parseInt(String.format("%d%d", first, last));
    }

}