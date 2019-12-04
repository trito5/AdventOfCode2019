import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dec04p2 {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 372037; i <= 905157; i++) {
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
                boolean isStartInGroup = true;
                boolean isEndInGroup = true;
                if ((i == 0) || (password.charAt(i - 1) != password.charAt(i))) {
                    isStartInGroup = false;
                }
                if ((i == password.length() - 2) || (password.charAt(i + 1) != password.charAt(i + 2))) {
                    isEndInGroup = false;
                }
                if (!isStartInGroup && !isEndInGroup) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isIncreasing(int number){
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add( number % 10 );
            number = number / 10;
        }
        Collections.reverse(digits);

        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
