import java.util.Arrays;
import java.util.List;

public class Dec09p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec09.txt";
        Common common = new Common();
        List<Long> inputs = common.readLineAndSplitOnCharToLongList(fileName,",");
        for (int i = inputs.size(); i < 44463349; i ++)
            inputs.add(0L);
        IntComputer intComputer = new IntComputer();
        List<Long> output = intComputer.run(inputs, Arrays.asList(1L));
        System.out.println(output);
    }
}