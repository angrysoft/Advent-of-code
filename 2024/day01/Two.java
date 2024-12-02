import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Two {

    public static void main(String[] args) throws IOException {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (var line : Files.readAllLines(Paths.get("input.txt"))) {
            var l = line.split("\s+");
            left.add(Integer.parseInt(l[0]));
            right.add(Integer.parseInt(l[1]));
        }

        int sum = 0;
        for (int i = 0; i < left.size(); ++i) {
            int c = 0;
            for (int r : right) {
                if (r == left.get(i)) ++c;
            }
            sum = sum + left.get(i) * c;
        }

        System.out.println(sum);
    }
}
