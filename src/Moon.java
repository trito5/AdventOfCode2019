public class Moon {

    public int x;
    public int y;
    public int z;

    public int xV;
    public int yV;
    public int zV;

    public Moon(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void calculateVelocity(Moon neighbour) {
        if (x < neighbour.x) {
            xV++;
            neighbour.xV --;
        } else if (x > neighbour.x) {
            xV--;
            neighbour.xV++;
        }

        if (y < neighbour.y) {
            yV++;
            neighbour.yV--;
        } else if (y > neighbour.y) {
            yV--;
            neighbour.yV++;
        }

        if (z < neighbour.z) {
            zV++;
            neighbour.zV--;
        } else if (z > neighbour.z) {
            zV--;
            neighbour.zV++;
        }
    }

    public void move() {
        x += xV;
        y += yV;
        z +=zV;
    }

    private int getPosEnergy() {
       return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    private int getKinEnergy() {
        return Math.abs(xV) + Math.abs(yV) + Math.abs(zV);
    }

    public int getTotalEnergy() {
        return getPosEnergy() * getKinEnergy();
    }

    @Override
    public String toString() {
        return "Moon{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", xV=" + xV +
                ", yV=" + yV +
                ", zV=" + zV +
                '}';
    }
}