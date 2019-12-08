import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec08p2 {
    public static void main(String[] args) {

        Common common = new Common();
        String fileName = "textFiles/dec08.txt";
        List<Integer> inputs = common.readIntFileAndSeparateRowInSignleInts(fileName);
        int layerSize = 25 * 6;
        int wide = 25;
        List<Integer> outputMessage = new ArrayList<>();

        createOutputMessage(inputs, layerSize, outputMessage);
        System.out.println("size: " + outputMessage.size());
        for(int i = 0; i < outputMessage.size(); i++) {
            if  (i % wide == 0)
                System.out.println();
            if (outputMessage.get(i) == 0) {
                System.out.print(" ");
            } else {
                System.out.print(outputMessage.get(i));
            }

        }
    }

    private static void createOutputMessage(List<Integer> inputs, int layerSize, List<Integer> outputMessage) {
        //First loop steps over digit positions in the layers
        for (int i = 0; i < layerSize; i++) {
            //Second loop steps over the diferent layers
            for (int j = i; j < inputs.size(); j = j + layerSize) {
                //Compare the digits in each layer
                if (inputs.get(j) == 1) {
                    outputMessage.add(1);
                    break;
                } else if(inputs.get(j) == 0) {
                    outputMessage.add(0);
                    break;
                }
            }
        }
    }
}
