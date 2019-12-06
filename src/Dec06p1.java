import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dec06p1 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec06.txt";
        Common common = new Common();
        List<String> inputs = common.readStringFile(fileName);
        Map<String, String> orbitMap = new HashMap<>();
        for (String orbit : inputs) {
            List<String> orbitPair = Arrays.asList(orbit.split("\\)"));
            orbitMap.put(orbitPair.get(1), orbitPair.get(0));
        }
        int total = 0;
        for (Map.Entry<String, String> entry : orbitMap.entrySet()) {
            total += getNumberOfOrbits(orbitMap, entry.getKey(), 0);
        }

        System.out.println(total);
    }

    private static int getNumberOfOrbits(Map<String, String> orbitMap, String startNode, int total)
    {
        if ("COM".equals(startNode)) {
            return total;
        } else {
            total ++;
            startNode = orbitMap.get(startNode);
            return getNumberOfOrbits(orbitMap, startNode, total);
        }
    }
}
