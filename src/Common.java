import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Common {

    public List<String> readStringFile(String fileName){
        List<String> inputs = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {

                inputs.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return inputs;
    }

    public List<Integer> readIntFile(String fileName) {
        List<Integer> inputs = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {

                inputs.add(Integer.parseInt(line));
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return inputs;
    }

    public int getSumOfList(List<Integer> inputs){
        int result = 0;
        for (int number : inputs) {
            result += number;
        }
        return result;
    }
}
