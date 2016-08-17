
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorEx {

Integer countAll=0;
    class MyRunnable implements Runnable {
        private String str;
        public Integer cnt=0;

        public Integer getCount() {
            return cnt;
        }

        public MyRunnable(String str) {
            this.str = str;

        }

        @Override
        public void run() {
            String[] s;

            //находим все места где подрят идут один или больше невидимых знаков(пробед, табуляция, и перенос строки)
            //меняем все это на пробел. "[ \t\n\r]+" - это regex выражение
           str = str.replaceAll("[ \t\n\r]+", " ");

            //находим все знаки не входяшие в русский или английский алфавит или пробел
            //и удаляем их. "[^a-zA-Zа-яА-Я ]" - опять regex
            str = str.replaceAll("[^a-zA-Zа-яА-Я ]", "");
            s = str.split(" ");

            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
                System.out.println( Thread.currentThread().getName());
            }
            str=str.replaceAll(" ","");
            cnt=cnt+str.length();
            System.out.println( "Количество слов "+cnt);
        }
    }

    // Run threads
    public void smain(ArrayList list,Integer num ) {

        ExecutorService executor = Executors.newFixedThreadPool(num);
     //   for (int i = 0; i < 6; i++) {
            for (int k = 0; k < list.size(); k++) {

                Runnable thread = new MyRunnable((String) list.get(k));
                executor.execute(thread);
                countAll=countAll;


            }

            // Accept no more new threads


            // Waiting for all the threads to finish
        executor.shutdown();

            while (!executor.isTerminated()) {
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }


     //   }

        System.out.println("[" + System.currentTimeMillis() + "][" + Thread.currentThread().getName() + "]:: done");


    }
}



