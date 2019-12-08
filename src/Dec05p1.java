import java.util.List;

public class Dec05p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec05.txt";
        Common common = new Common();
        List<Integer> inputs = common.readLineAndSplitOnCharToIntList(fileName, ",");
        IntComputer intComputer = new IntComputer();
        List<Integer> outputs = intComputer.run(inputs, List.of(1));

        for (int number : outputs) {
            System.out.println(number);
        }
    }
}
