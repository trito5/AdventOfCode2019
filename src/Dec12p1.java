public class Dec12p1 {
    public static void main(String[] args) {
        Moon a = new Moon(0, 6, 1);
        Moon b = new Moon(4, 4, 19);
        Moon c = new Moon(-11, 1, 8);
        Moon d = new Moon(2, 19, 15);
        for (int i = 0; i < 1000; i++) {
            a.calculateVelocity(b);
            a.calculateVelocity(c);
            a.calculateVelocity(d);

            b.calculateVelocity(c);
            b.calculateVelocity(d);

            c.calculateVelocity(d);

            a.move();
            b.move();
            c.move();
            d.move();
        }
        int energy = a.getTotalEnergy() + b.getTotalEnergy() + c.getTotalEnergy() + d.getTotalEnergy();
        System.out.println(energy);

    }
}
