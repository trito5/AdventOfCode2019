public class Dec02p2 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec02.txt";
        Common common = new Common();
        String line = common.readLine(fileName);
        String[] stringNumbers = line.split(",");

        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        int noun;
        int verb;

        for (noun = 0; noun < 100; noun ++){
            for (verb = 0; verb < 100; verb ++){
                if (isFirstIndexCorrect(noun, verb, intNumbers)) {
                    System.out.println(100 * noun + verb);
                    break;
                }
            }
        }
    }

    private static boolean isFirstIndexCorrect(int noun, int verb, int[] startNumbers) {
        int[] numbers = new int[startNumbers.length];

        for (int i = 0 ; i < numbers.length; i ++) {
            numbers[i] = startNumbers[i];
        }

        numbers[1] = noun;
        numbers[2] = verb;

        for (int pointer = 0; pointer < numbers.length - 3; pointer += 4) {
            if (numbers[pointer] == 99) {
                break;
            }
            if (numbers[pointer] == 1) {
                numbers[numbers[pointer + 3]] = numbers[numbers[pointer + 1]] + numbers[numbers[pointer + 2]];
            } else if (numbers[pointer] == 2) {
                numbers[numbers[pointer + 3]] = numbers[numbers[pointer + 1]] * numbers[numbers[pointer + 2]];
            } else {
                System.out.println("Error: " + noun + ":" + verb);
            }
        }
        return (numbers[0] == 19690720);
    }
}
