import java.util.List;

public class Dec01p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec01.txt";
        Common common = new Common();
        List<Integer> inputs = common.readIntFile(fileName);
        int result = 0;

        for (int mass : inputs) {
            result += mass / 3 - 2;
        }
        System.out.println(result);
    }
}
