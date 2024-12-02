import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class One {

    public static void main(String[] args) throws IOException {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (var line : Files.readAllLines(Paths.get("input.txt"))) {
            var l = line.split("\s+");
            left.add(Integer.parseInt(l[0]));
            right.add(Integer.parseInt(l[1]));
        }

        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());
        int sum = 0;
        for (int i = 0; i < left.size(); ++i) {
            int d = (right.get(i) - left.get(i));
            if (d < 0) {
                d = d *-1;
            }
            sum = sum + d;
        }

        System.out.println(sum);
    }
}
