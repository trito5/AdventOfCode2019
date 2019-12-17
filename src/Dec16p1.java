import java.util.*;

public class Dec16p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec16.txt";
        Common common = new Common();
        List<Integer> inputs = common.readIntFileAndSeparateRowInSignleInts(fileName);
        List<Integer> newInputs = new ArrayList<>();
        List<Integer> phases = new ArrayList<>();
        for (int c = 0; c < 100; c++) {
            newInputs.clear();
            for (int i = 0; i < inputs.size(); i++) {
                int phasePosition = 0;
                adjustPhases(phases, i + 1);
                int sum = 0;
                for (int k = 0; k < inputs.size(); k++) {
                    if (phasePosition >= phases.size() - 1) {
                        phasePosition = 0;
                    } else {
                        phasePosition++;
                    }
                    sum = sum + inputs.get(k) * phases.get(phasePosition);
                }
                newInputs.add(Math.abs(sum % 10));
            }
            inputs.clear();
            for (int digit : newInputs)
                inputs.add(digit);
        }

        System.out.println(Arrays.toString(newInputs.toArray()));
    }

    private static void adjustPhases(List<Integer> phases, int position) {
        phases.clear();
        for (int i = 0; i < position; i++)
            phases.add(0);
        for (int i = 0; i < position; i++)
            phases.add(1);
        for (int i = 0; i < position; i++)
            phases.add(0);
        for (int i = 0; i < position; i++)
            phases.add(-1);
    }
}
