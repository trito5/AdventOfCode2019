import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dec03p2 {

    public static void main(String[] args) {
        String fileName = "textFiles/dec03.txt";
        Common common = new Common();
        List<String> inputs = common.readStringFile(fileName);
        String[] c1Positions = inputs.get(0).split(",");
        String[] c2Positions = inputs.get(1).split(",");
        List<NodeWithSteps> pos1Nodes = addNode(c1Positions);
        List<NodeWithSteps> pos2Nodes = addNode(c2Positions);

        int leastSteps = 100000;
        for (int i = 0; i < pos1Nodes.size(); i ++) {
            for (int j = 0; j < pos2Nodes.size(); j ++) {
                if (pos1Nodes.get(i).equals(pos2Nodes.get(j))) {
                    if (!(pos1Nodes.get(i).x == 0 && pos1Nodes.get(i).y == 0)) {
                        int totalSteps = pos1Nodes.get(i).steps + pos2Nodes.get(j).steps;
                        if (totalSteps < leastSteps)
                            leastSteps = totalSteps;
                    }
                }
            }
        }

        System.out.println("Steps: " + leastSteps);

    }

    private static List<NodeWithSteps> addNode(String[] positions ) {
        List<NodeWithSteps> nodeList = new ArrayList<>();
        int lastStep = 0;
        nodeList.add(new NodeWithSteps(0, 0, lastStep));
        for (String pos : positions) {
            char direction = pos.charAt(0);
            int steps = Integer.parseInt(pos.substring(1));
            int lastX = nodeList.get(nodeList.size() - 1).x;
            int lastY = nodeList.get(nodeList.size() - 1).y;

            switch (direction) {
                case 'U':
                    for(int i = 0; i < steps; i ++) {
                        lastStep = nodeList.get(nodeList.size() - 1).steps;
                        lastY = nodeList.get(nodeList.size() - 1).y;
                        nodeList.add(new NodeWithSteps(lastX, lastY - 1, lastStep + 1));
                    }
                    break;
                case 'R':
                    for(int i = 0; i < steps; i ++) {
                        lastStep = nodeList.get(nodeList.size() - 1).steps;
                        lastX = nodeList.get(nodeList.size() - 1).x;
                        nodeList.add(new NodeWithSteps(lastX + 1, lastY, lastStep + 1));
                    }
                    break;
                case 'D':
                    for(int i = 0; i < steps; i ++) {
                        lastStep = nodeList.get(nodeList.size() - 1).steps;
                        lastY = nodeList.get(nodeList.size() - 1).y;
                        nodeList.add(new NodeWithSteps(lastX, lastY + 1, lastStep + 1));
                    }
                    break;
                case 'L':
                    for(int i = 0; i < steps; i ++) {
                        lastStep = nodeList.get(nodeList.size() - 1).steps;
                        lastX = nodeList.get(nodeList.size() - 1).x;
                        nodeList.add(new NodeWithSteps(lastX - 1, lastY, lastStep + 1));
                    }
                    break;
                default:
                    System.out.println("Read input direction wrong");
                    break;
            }
        }
        return nodeList;
    }
}
