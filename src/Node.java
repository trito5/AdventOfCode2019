import java.util.Objects;

public class Node {

        public int x;
        public int y;
        public int length;
        public int steps;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.length = Math.abs(x) + Math.abs(y);
        }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                " , length: " + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
