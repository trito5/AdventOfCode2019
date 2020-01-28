import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec19p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec19.txt";
        Common common = new Common();
        List<Long> startInputs = common.readLineAndSplitOnCharToLongList(fileName,",");
        for (int i = startInputs.size(); i < 5000; i ++)
            startInputs.add(0L);
        int sum = 0;

        List<Long> inputForIteration = new ArrayList<>();

        for (long i = 0;  i < 50; i++) {
            for (long j = 0; j < 50; j++) {
                IntComputer intComputer = new IntComputer();
                inputForIteration.clear();
                for (long digit : startInputs) {
                    inputForIteration.add(digit);
                }
                List<Long> output = intComputer.run(inputForIteration, List.of(j, i));
                System.out.print(output.get(0));

                if (output.get(0) == 1)
                    sum++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(sum);

    }
}