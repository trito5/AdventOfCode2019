import java.util.Arrays;
import java.util.List;

public class Dec13p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec13.txt";
        Common common = new Common();
        List<Long> inputs = common.readLineAndSplitOnCharToLongList(fileName,",");
        for (int i = inputs.size(); i < 3000; i ++)
            inputs.add(0L);
        IntComputer intComputer = new IntComputer();
        List<Long> output = intComputer.run(inputs, Arrays.asList(1L));

        long blocks = 0;
        for (int i = 2; i < output.size(); i = i + 3) {
            if (output.get(i) == 2) {
                blocks ++;
            }
        }
        System.out.println("blcoks: " + blocks);
    }
}