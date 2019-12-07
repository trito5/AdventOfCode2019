import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntComputer {
    private int index = 0;

    public void run(List<Integer> inputs, int startInput) {
        while (true) {
            int opCode = inputs.get(index);
            int opCodeAB = opCode % 100;
            if (opCodeAB == 99) {
                break;
            }

            List<Integer> opCodesCDE = separateOpCode(opCode);
            for (int i = opCodesCDE.size(); i <=5; i ++)
                opCodesCDE.add(0);

            switch (opCodeAB) {
                case 1:
                    inputs.set(inputs.get(index + 3), getValue(inputs, opCodesCDE.get(0), index + 1) + getValue(inputs, opCodesCDE.get(1), index + 2));
                    index += 4;
                    break;
                case 2:
                    inputs.set(inputs.get(index + 3), getValue(inputs, opCodesCDE.get(0), index + 1) * getValue(inputs, opCodesCDE.get(1), index + 2));
                    index += 4;
                    break;
                case 3:
                    inputs.set(inputs.get(index + 1), startInput);
                    index += 2;
                    break;
                case 4:
                    System.out.println(inputs.get(inputs.get(index + 1)));
                    index += 2;
                    break;
            }
        }
    }

    private int getValue(List<Integer> inputs, int mode, int index) {
        if(mode == 1) {
            return inputs.get(index);
        } else {
            return  inputs.get(inputs.get(index));
        }
    }

    private static List<Integer> separateOpCode(int opCode) {

        List<Integer> opCodeCommands = new ArrayList<>();
        opCode = opCode / 100;
        while (opCode > 0) {
            opCodeCommands.add(opCode % 10);
            opCode = opCode / 10;
        }
        return  opCodeCommands;
    }
}
