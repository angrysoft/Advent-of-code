package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        System.out.println(parseInputFile("/home/seba/workspace/Advent-of-code-2023/Day02/input.txt"));
    }

    public static int parseInputFile(String name) {
        int result = 0;
        File inputFile = new File(name);
        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] gameInfo = line.split(":", 2);
                if (gameInfo.length < 2)
                    continue;
                    result += gameScore(gameInfo[1]);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static int gameScore(String gameStat) {
        int red = 1;
        int green = 1;
        int blue = 1;

        for (String round : gameStat.split(";")) {
            for (String color : round.trim().split(",")) {
                String[] cubs = color.trim().split(" ");
                Integer value = Integer.parseInt(cubs[0]);

                switch (cubs[1]) {
                    case "red":
                        red = Math.max(red, value);
                        break;
                    case "green":
                        green = Math.max(green, value);
                        break;
                    case "blue":
                        blue = Math.max(blue, value);
                        break;
                    default:
                        break;
                }
            }
        }
        return red * green * blue;
    }
}
