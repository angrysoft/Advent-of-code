package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class First {

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
                if (isGamePossible(gameInfo[1])) {
                    result += getGameId(gameInfo[0]);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static int getGameId(String in) {
        return Integer.parseInt(in.split(" ")[1]);
    }

    public static boolean isGamePossible(String gameStat) {
        for (String round : gameStat.split(";")) {
            for (String color : round.trim().split(",")) {
                String[] cubs = color.trim().split(" ");
                Integer value = Integer.parseInt(cubs[0]);

                switch (cubs[1]) {
                    case "red":
                        if (value > 12)
                            return false;
                        break;
                    case "green":
                        if (value > 13)
                            return false;
                        break;
                    case "blue":
                        if (value > 14)
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }
}
