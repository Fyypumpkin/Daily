package other.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fyypumpkin on 2018/7/12
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        Run[] run = new Run[5];

        for(int i=0;i<5;i++){
            run[i] = new Run(i, begin, end);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(Run r : run){
            executorService.execute(r);
        }

        begin.countDown();

        try{
            end.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("end");
        }

        executorService.shutdown();

    }


}


class Run implements Runnable{
    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;


    public Run(int i, CountDownLatch begin, CountDownLatch end){
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try{
            begin.await();
            Thread.sleep((long)(Math.random()*100*100));
            System.out.println(this.id + " arrived");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }
}