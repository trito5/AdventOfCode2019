import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dec03p1 {

    public static void main(String[] args) {
        String fileName = "textFiles/dec03.txt";
        Common common = new Common();
        List<String> inputs = common.readStringFile(fileName);
        String[] c1Positions = inputs.get(0).split(",");
        String[] c2Positions = inputs.get(1).split(",");
        List<Node> pos1Nodes = addNode(c1Positions);
        List<Node> pos2Nodes = addNode(c2Positions);

        Set<Node> pos2NodesHash = new HashSet<>(pos2Nodes);

        int shortestDistance = 100000;
        for (int i = 0; i < pos1Nodes.size(); i ++) {

            if (pos2NodesHash.contains(pos1Nodes.get(i))) {

                if (pos1Nodes.get(i).length != 0 && pos1Nodes.get(i).length  <= shortestDistance)
                        shortestDistance = pos1Nodes.get(i).length;
            }
        }
        System.out.println("*********************");
        for (Node node : pos2NodesHash) {
            System.out.println(node.toString());
        }
        System.out.println("Shortest distance: " + shortestDistance);

    }

    private static List<Node> addNode(String[] positions ) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(0, 0));
        for (String pos : positions) {
            char direction = pos.charAt(0);
            int steps = Integer.parseInt(pos.substring(1));
            int lastX = nodeList.get(nodeList.size() - 1).x;
            int lastY = nodeList.get(nodeList.size() - 1).y;

            switch (direction) {
                case 'U':
                    for(int i = 0; i < steps; i ++) {
                        lastY = nodeList.get(nodeList.size() - 1).y;
                        nodeList.add(new Node(lastX, lastY - 1));
                    }
                    break;
                case 'R':
                    for(int i = 0; i < steps; i ++) {
                        lastX = nodeList.get(nodeList.size() - 1).x;
                        nodeList.add(new Node(lastX + 1, lastY));
                    }
                    break;
                case 'D':
                    for(int i = 0; i < steps; i ++) {
                        lastY = nodeList.get(nodeList.size() - 1).y;
                        nodeList.add(new Node(lastX, lastY + 1));
                    }
                    break;
                case 'L':
                    for(int i = 0; i < steps; i ++) {
                        lastX = nodeList.get(nodeList.size() - 1).x;
                        nodeList.add(new Node(lastX - 1, lastY));
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
