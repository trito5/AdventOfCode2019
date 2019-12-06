import java.util.List;

public class Dec01p2 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec01.txt";
        Common common = new Common();
        List<Integer> inputs = common.readIntFile(fileName);
        int totalFuelMass = 0;

        for (int input : inputs) {
            totalFuelMass += fact(input, 0);
        }

        System.out.println("TotalFuelMass: " + totalFuelMass);
    }

    private static int fact(int mass, int total)
    {
        if (mass <= 0) {
            return total;
        } else {
            int newMass = mass/3 - 2;
            if (newMass >= 0) {
                total += newMass;
            }
            return fact(newMass, total);
        }
    }
}