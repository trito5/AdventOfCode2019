import java.util.ArrayList;
import java.util.List;

public class Dec04p1 {
    public static void main(String[] args) {
        //372037-905157
        int maxNumbers = 905157 - 372037;
        int counter = 0;
        for (int i = 372037; i <= maxNumbers; i++) {
            if (hasOneDouble(i) && isIncreasing(i)) {
                counter ++;
            }
        }
        System.out.println(counter);
    }

    private static boolean hasOneDouble(int number) {
        String password = String.valueOf(number);
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIncreasing(int number){
        String password = String.valueOf(number);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < password.length() - 2; i++) {
            int n = Integer.parseInt(password.substring(i, i + 1));
            int m = Integer.parseInt(password.substring(i + 1, i + 2));
            if (n == m || n < m) {
                return true;
            }
        }
        return false;
    }
}
