import java.util.List;

public class Dec08p1 {
    public static void main(String[] args) {

        Common common = new Common();
        String fileName = "textFiles/dec08.txt";
        List<Integer> inputs = common.readIntFileAndSeparateRowInSignleInts(fileName);
        int layerSize = 25 * 6;
        int startIndexOfLeastZeros = 0;
        int leastNumberOfZeros = 100000000;

        startIndexOfLeastZeros = getStartIndexOfLeastZeros(inputs, layerSize, startIndexOfLeastZeros, leastNumberOfZeros);
        int result = getResult(inputs, layerSize, startIndexOfLeastZeros);
        System.out.println(result);
    }

    private static int getResult(List<Integer> inputs, int layerSize, int startIndexOfLeastZeros) {
        int numberOf1 = 0;
        int numberOf2 = 0;
        for (int i = startIndexOfLeastZeros; i < startIndexOfLeastZeros + layerSize; i ++) {
            if (inputs.get(i) == 1) {
                numberOf1++;
            } else if (inputs.get(i) == 2) {
                numberOf2++;
            }
        }
        return numberOf1 * numberOf2;
    }

    private static int getStartIndexOfLeastZeros(List<Integer> inputs, int layerSize, int startIndexOfLeastZeros, int leastNumberOfZeros) {
        for (int i = 0; i < inputs.size(); i = i + layerSize) {
            //Second loop steps over digits in 1 layer
            int zeroCounter = 0;
            for (int j = i; j < i + layerSize; j ++) {
                if (inputs.get(j) == 0) {
                    zeroCounter ++;
                }
            }
            if (zeroCounter < leastNumberOfZeros) {
                leastNumberOfZeros = zeroCounter;
                startIndexOfLeastZeros = i;
            }
        }
        return startIndexOfLeastZeros;
    }
}
