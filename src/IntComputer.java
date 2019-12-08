import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntComputer {
    private int index = 0;
    private int indexInSystemInputs = 0;
    private List<Integer> outputs = new ArrayList<>();

    public List<Integer> run(List<Integer> inputs, List<Integer> sytemInputs) {
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
                    inputs.set(inputs.get(index + 1), sytemInputs.get(indexInSystemInputs));
                    indexInSystemInputs ++;
                    index += 2;
                    break;
                case 4:
                    outputs.add(getValue(inputs, opCodesCDE.get(0),(index + 1)));
                    index += 2;
                    break;
                case 5:
                    int valueC5 = getValue(inputs, opCodesCDE.get(0), index + 1);
                    if(valueC5 != 0) {
                        index = getValue(inputs, opCodesCDE.get(1), index + 2);
                    } else {
                        index += 3;
                    }
                    break;
                case 6:
                    int valueC6 = getValue(inputs, opCodesCDE.get(0), index + 1);
                    if(valueC6 == 0) {
                        index = getValue(inputs, opCodesCDE.get(1), index + 2);
                    } else {
                        index += 3;
                    }
                    break;
                case 7:
                    int valueC7 = 0;
                    if(getValue(inputs, opCodesCDE.get(0), index + 1) < getValue(inputs, opCodesCDE.get(1), index + 2)) {
                        valueC7 = 1;
                    }
                    inputs.set(inputs.get(index + 3), valueC7);
                    index += 4;
                    break;
                case 8:
                    int valueC8 = 0;
                    if(getValue(inputs, opCodesCDE.get(0), index + 1) == getValue(inputs, opCodesCDE.get(1), index + 2))  {
                        valueC8 = 1;
                    }
                    inputs.set(inputs.get(index + 3), valueC8);
                    index += 4;
                    break;
                default:
                    System.out.println("Something went wrong in the switch " + opCodeAB);
                    break;
            }
        }
        return outputs;
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
