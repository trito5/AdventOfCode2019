import java.util.*;

public class Dec06p2 {
    public static void main(String[] args) {
        String fileName = "textFiles/dec06.txt";
        Common common = new Common();
        List<String> inputs = common.readStringFile(fileName);
        Map<String, String> orbitMap = new HashMap<>();
        for (String orbit : inputs) {
            List<String> orbitPair = Arrays.asList(orbit.split("\\)"));
            orbitMap.put(orbitPair.get(1), orbitPair.get(0));
        }
        List<String> myPath = new ArrayList<>();
        List<String> santasPath = new ArrayList<>();

        getNumberOfOrbits(orbitMap, orbitMap.get("YOU"), myPath);
        getNumberOfOrbits(orbitMap, orbitMap.get("SAN"), santasPath);

        int santasCounter = 0;
        Set<String> orbitPath = new HashSet<>(myPath);
        for (String santaOrbit : santasPath) {
            if (orbitPath.contains(santaOrbit)) {
                break;
            }
            santasCounter++;
        }
        int myCounter = myPath.indexOf(santasPath.get(santasCounter));
        System.out.println(santasCounter + myCounter + 2);
    }


    private static List<String> getNumberOfOrbits(Map<String, String> orbitMap, String startNode, List<String> path)
    {
        if ("COM".equals(startNode)) {
            return path;
        } else {
            startNode = orbitMap.get(startNode);
            path.add(startNode);
            return getNumberOfOrbits(orbitMap, startNode, path);
        }
    }
}
