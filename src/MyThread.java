import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by svetlanashmalko on 17.08.16.
 */
public class MyThread {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner file = null;
        try {
            file = new Scanner(new File("Text/my_text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (file.hasNext())

            list.add(file.nextLine());

        file.close();;

        Scanner file1 = null;
        Integer num = null;
        try {
            file1 = new Scanner(new File("Text/Num.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (file1.hasNext()) {
            num = Integer.valueOf(file1.nextLine());
        }
       System.out.println(num);
        file1.close();;

            ExecutorEx ex = new ExecutorEx();
            ex.smain(list,num);






    }

}

