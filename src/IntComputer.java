import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class IntComputer {
    private int index = 0;
    private long relativeBase = 0;
   // public int indexInSystemInputs = 0;
    private Map<Integer, Integer> outOfBoundValues = new HashMap<>();
    List<Long> inputQeue = new LinkedList<>();
    private List<Long> outputs = new ArrayList<>();
    public boolean breakPointReached = false;

    public List<Long> run(List<Long> inputs, List<Long> systemInputs) {
        for (long input : systemInputs)
            inputQeue.add(input);
        while (true) {
            int opCode = inputs.get(index).intValue();
            System.out.println(opCode);
            int opCodeAB = opCode % 100;
            if (opCodeAB == 99) {
                breakPointReached = true;
                break;
            }
            List<Integer> opCodesCDE = separateOpCode(opCode);
            for (int i = opCodesCDE.size(); i <6; i ++)
                opCodesCDE.add(0);

            switch (opCodeAB) {
                case 1:
                    inputs.set(getWritePosition(inputs.get(index + 3).intValue(), opCodesCDE.get(2)), getValue(inputs, opCodesCDE.get(0), index + 1) + getValue(inputs, opCodesCDE.get(1), index + 2));
                    index += 4;
                    break;
                case 2:
                    inputs.set(getWritePosition(inputs.get(index + 3).intValue(), opCodesCDE.get(2)), getValue(inputs, opCodesCDE.get(0), index + 1) * getValue(inputs, opCodesCDE.get(1), index + 2));
                    index += 4;
                    break;
                case 3:
       /*             if (indexInSystemInputs > sytemInputs.size() - 1)
                        indexInSystemInputs = sytemInputs.size() - 1;*/
                    long systemInput = (long) inputQeue.get(0);
                    inputQeue.remove(0);
                    inputs.set(getWritePosition(inputs.get(index + 1).intValue(), opCodesCDE.get(0)), systemInput);
                    //indexInSystemInputs ++;
                    index += 2;
                    break;
                case 4:
                    outputs.add(getValue(inputs, opCodesCDE.get(0), index + 1));
                    inputQeue.add(getValue(inputs, opCodesCDE.get(0), index + 1));
                    //sytemInputs.add((int) getValue(inputs, opCodesCDE.get(0), index + 1));
                    index += 2;
                    break;
                case 5:
                    long valueC5 = getValue(inputs, opCodesCDE.get(0), index + 1);
                    if(valueC5 != 0) {
                        index = (int) getValue(inputs, opCodesCDE.get(1), index + 2);
                        System.out.println("index : " + index + " value new index: " + inputs.get(index));
                    } else {
                        index += 3;
                        System.out.println("nähe vi kom hit");
                    }
                    break;
                case 6:
                    long valueC6 = getValue(inputs, opCodesCDE.get(0), index + 1);
                    if(valueC6 == 0) {
                        index = (int) getValue(inputs, opCodesCDE.get(1), index + 2);
                    } else {
                        index += 3;
                    }
                    break;
                case 7:
                    long valueC7 = 0;
                    if(getValue(inputs, opCodesCDE.get(0), index + 1) < getValue(inputs, opCodesCDE.get(1), index + 2)) {
                        valueC7 = 1;
                    }
                    inputs.set(getWritePosition(inputs.get(index + 3).intValue(), opCodesCDE.get(2)), valueC7);
                    index += 4;
                    break;
                case 8:
                    long valueC8 = 0;
                    if(getValue(inputs, opCodesCDE.get(0), index + 1) == getValue(inputs, opCodesCDE.get(1), index + 2))  {
                        valueC8 = 1;
                    }
                    inputs.set(getWritePosition(inputs.get(index + 3).intValue(), opCodesCDE.get(2)), valueC8);
                    index += 4;
                    break;
                case 9:
                   // relativeBase = getValue(inputs, opCodesCDE.get(0), index + 1);
                    if (opCodesCDE.get(0) == 1) {
                        relativeBase += inputs.get(index + 1);
                    } else if (opCodesCDE.get(0) == 0){
                        relativeBase += inputs.get(inputs.get(index + 1).intValue());
                    } else {
                        relativeBase += inputs.get((int)relativeBase + inputs.get(index + 1).intValue());
                    }
                    //relativeBase = getWritePosition(inputs.get(index + 1).intValue(), opCodesCDE.get(0));
                    index +=2;
                    break;
                default:
                    System.out.println("Something went wrong in the switch " + opCodeAB);
                    break;
            }
        }

        //return outputs;
       return inputQeue;
    }

    private long getValue(List<Long> inputs, int mode, int index) {
        if(mode == 1) {
            if (isOutOfBounds(index, inputs)) {
                if(outOfBoundValues.containsKey(index))
                    return outOfBoundValues.get(index);
                else
                    outOfBoundValues.put(index, 0);
                return outOfBoundValues.get(index);
            }
            return inputs.get(index);
        } else if (mode == 0){
            if (isOutOfBounds(inputs.get(index).intValue(), inputs)) {
                if(outOfBoundValues.containsKey(index))
                    return outOfBoundValues.get(index);
                else
                    outOfBoundValues.put(index, 0);
                return outOfBoundValues.get(index);
            }
            return  inputs.get(inputs.get(index).intValue());
        } else {
            return inputs.get((int) relativeBase + inputs.get(index).intValue());
        }
    }

    private boolean isOutOfBounds(int key, List<Long> inputs) {
        return (key > inputs.size()-1);
    }

    private int getWritePosition(int index, int mode){
        //relativeBase + inputs.get(index + 1)
        if (mode == 2) {
            return index + (int) relativeBase;
        } else {
            return index;
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
