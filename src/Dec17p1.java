import java.util.*;

public class Dec17p1 {
    public static void main(String[] args) {
        Common common = new Common();
        String fileName = "textFiles/dec17.txt";
        List<Long> inputs = common.readLineAndSplitOnCharToLongList(fileName, ",");
        for (int i = inputs.size(); i < 5000; i++)
            inputs.add(0L);
        IntComputer intComputer = new IntComputer();

        List<Long> outputs = intComputer.run(inputs, Collections.emptyList());
        List<ColorNode> map = new ArrayList<>();
        int x = 0;
        int y = 0;
        int width = 38;
        int tempCounter = 0;
        System.out.print(" ");
        for (int i = 0; i <= 38; i ++) {
            System.out.print(tempCounter);
            if (tempCounter >= 9)
                tempCounter = 0;
            else
                tempCounter++;
        }
        System.out.println();
        for (long digit : outputs) {
            if (digit == 46) {
                map.add(new ColorNode(x, y, 46));
                x++;
                System.out.print(".");
            } else if (digit == 35) {
                map.add(new ColorNode(x, y, 35));
                x++;
                System.out.print("#");
            } else if (digit == 10) {
                y++;
                x = 0;
                System.out.println();
                System.out.print(y % 10);
            } else {
                map.add(new ColorNode(x, y, 0));
                x++;
                System.out.print(digit);
            }
        }

        int sum = 0;
        for (int i = 0; i < map.size(); i ++) {
            if (i > width && i < map.size() - width && i % width != 0 && i % (width + 1) != 0) {
                //om noden har karta
                if (map.get(i).color == 35) {
                    // om i == den första platsen i varje rad
                    if (map.get(i - 1).color == 35) {
                        // om i == 38
                        if (map.get(i + 1).color == 35) {
                            // om i < 38
                            if (map.get(i - width - 1).color == 35) {
                                // om i är större eler lika med (inte sista raden
                                if (map.get(i + width + 1).color == 35) {
                                    System.out.println("intersect " + map.get(i));
                                    sum = sum + (map.get(i).x * map.get(i).y);
                                }
                            }
                        }
                    }

                }
            }

        }
        System.out.println("Sum: " + sum);

    }

}
