import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class One {

    public static void main(String[] args) throws IOException {

        try (var s = Files.lines(Paths.get("input.txt"))) {
            var sum = s.filter(l -> {
                var result = true;
                List<Integer> num = new ArrayList<>();
                for (String numS : l.split("\s")) {
                    num.add(Integer.parseInt(numS));
                }
                int dir = num.get(1).compareTo(num.get(0));
                for (var i = 0; i < num.size() - 1; i++) {
                    if (num.get(i+1).compareTo(num.get(i)) != dir) {
                        result = false;
                        break;
                    }
                    if (dir > 0 && (num.get(i + 1) - num.get(i)) > 3)
                            result = false;
                    if (dir < 0 && (num.get(i) - num.get(i+1)) > 3) result = false;
                    
                }
                // System.out.println("%s $%s".formatted(num, result));
                return result;
            }).count();
            System.out.println(sum);
        }

    }
}
