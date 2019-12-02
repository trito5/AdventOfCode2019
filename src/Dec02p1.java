public class Dec02p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec02.txt";
        Common common = new Common();
        String line = common.readLine(fileName);
        String[] stringNumbers = line.split(",");
        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        intNumbers[1] = 12;
        intNumbers[2] = 2;

        for (int i = 0; i < intNumbers.length - 3; i += 4){
            if (intNumbers[i] == 99) {
                break;
            }
            intNumbers[intNumbers[i + 3]] = getNewValue(intNumbers[i], intNumbers[intNumbers[i + 1]], intNumbers[intNumbers[i + 2]]);
        }
        System.out.println(intNumbers[0]);
    }

    private static int getNewValue(int method, int b, int c){
        if (method == 1) {
            return b + c;
        } else {
            return b * c;
        }
    }
}
