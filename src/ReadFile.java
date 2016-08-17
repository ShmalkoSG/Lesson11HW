import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by svetlanashmalko on 17.08.16.
 */
public class ReadFile {
    public List<String> my_col = new ArrayList<>();

    public ReadFile(String fileName) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                my_col.add(line);
            }

        } catch (IOException e) {
            System.out.println("Wrong");
        }
    }
}