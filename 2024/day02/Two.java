import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Two {

    public static void main(String[] args) throws IOException {

        try (var s = Files.lines(Paths.get("input.txt"))) {
            var sum = s.filter(l -> {
                var result = true;
                List<Integer> num = new ArrayList<>();
                for (String numS : l.split("\s")) {
                    num.add(Integer.parseInt(numS));
                }

                result = checkNum(num);
                int i = 0;
                while (!result && i < num.size()) {
                    var reduced = new ArrayList<>(num);
                    reduced.remove(i);
                    result = checkNum(reduced);
                    if (result) break;
                    ++i;
                } 
                return result;
            }).count();
            System.out.println(sum);
        }


        
    }

    static boolean checkNum(List<Integer> num) {
        System.out.println(num);
        var result = true;
        int dir = num.get(1).compareTo(num.get(0));
        if (dir == 0) return false;
        for (var i = 0; i < num.size() - 1; i++) {
            if (num.get(i + 1).compareTo(num.get(i)) != dir) {
                result = false;
                break;
            }
            if (dir > 0 && (num.get(i + 1) - num.get(i)) > 3)
                result = false;
            if (dir < 0 && (num.get(i) - num.get(i + 1)) > 3)
                result = false;

        }
        // System.out.println("%s $%s".formatted(num, result));
        return result;
    }
}
