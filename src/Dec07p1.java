import java.util.*;

public class Dec07p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec07.txt";
        Common common = new Common();
        int highestValue = 0;
        List<Integer> phases = new ArrayList<>();
        permutation("", "01234", phases);
        for (int phase : phases) {
            int output = testPhases(phase, common, fileName);
            if (output > highestValue) {
                highestValue = output;
            }
        }
        System.out.println(highestValue);
    }

    private static void permutation(String prefix, String str, List<Integer> phases) {
        int n = str.length();
        if (n == 0) {
            phases.add(Integer.parseInt(prefix));
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), phases);
        }
    }
    private static List<Integer> separatePhases(int phase) {

        List<Integer> phases = new ArrayList<>();

        while (phase > 0) {
            phases.add(phase % 10);
            phase = phase / 10;
        }
        Collections.reverse(phases);
        return  phases;
    }

    private static int testPhases(int phase, Common common, String fileName) {
        IntComputer ampA = new IntComputer();
        IntComputer ampB = new IntComputer();
        IntComputer ampC = new IntComputer();
        IntComputer ampD = new IntComputer();
        IntComputer ampE = new IntComputer();
        List<Integer> inputsA = common.readLineAndSplitOnCharToIntList(fileName, ",");
        List<Integer> inputsB = common.readLineAndSplitOnCharToIntList(fileName, ",");
        List<Integer> inputsC = common.readLineAndSplitOnCharToIntList(fileName, ",");
        List<Integer> inputsD = common.readLineAndSplitOnCharToIntList(fileName, ",");
        List<Integer> inputsE = common.readLineAndSplitOnCharToIntList(fileName, ",");

        List<Integer> phases = separatePhases(phase);
        if (phases.size() < 5) {
            phases.add(0, 0);
        }

        List<Integer> outputsA = ampA.run(inputsA, Arrays.asList(phases.get(0), 0));
        List<Integer> outputsB = ampB.run(inputsB, Arrays.asList(phases.get(1), outputsA.get(0)));
        List<Integer> outputsC = ampC.run(inputsC, Arrays.asList(phases.get(2), outputsB.get(0)));
        List<Integer> outputsD = ampD.run(inputsD, Arrays.asList(phases.get(3), outputsC.get(0)));
        List<Integer> outputsE = ampE.run(inputsE, Arrays.asList(phases.get(4), outputsD.get(0)));

        return outputsE.get(0);
    }


}
