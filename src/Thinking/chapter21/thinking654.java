package Thinking.chapter21;

import java.util.concurrent.*;

public class thinking654 implements Runnable{
    protected int countDown = 10;
    private static int taskId = 0;
    private final int id = taskId++;
    public thinking654(){}
    public thinking654(int countDown){
        this.countDown = countDown;
    }

    public int egtId() {
        return this.id;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "fire") + "), " + "current thread: " + Thread.currentThread().getName() + " current active: "+ Thread.activeCount() + " currentTaskId: "+this.id;
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
//            Thread.yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        thinking654 thinking654 = new thinking654();
        thinking654 thinking6541 = new thinking654();
        Thread test = new Thread(thinking654);
        Thread test2 = new Thread(thinking6541);
        test.start();
        test2.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class ConMain {
    public static void main(String[] args) {
//        ConMain.cachePool();
//        ConMain.FixPool();
        ConMain.singlePool();
    }

    private static void cachePool(){
        ExecutorService service = Executors.newCachedThreadPool();
        thinking654 thinking654 = new thinking654(2);
        thinking654 thinking6541 = new thinking654();
        thinking654 thinking6542 = new thinking654();
        service.execute(thinking654);
        service.execute(thinking6541);
        service.shutdown();
//        service.execute(thinking6542);
    }

    private static void FixPool() {
        ExecutorService service = Executors.newFixedThreadPool(2); // 指定长度的
        thinking654 thinking654 = new thinking654(2);
        thinking654 thinking6541 = new thinking654();
        thinking654 thinking6542 = new thinking654();
        service.execute(thinking654);
        service.execute(thinking6541);
        service.shutdown();
        service.execute(thinking6542);
    }

    private static void singlePool() {
        ExecutorService service = Executors.newSingleThreadExecutor(); // 会顺序执行多个任务
        thinking654 thinking654 = new thinking654(5);
        thinking654 thinking6541 = new thinking654(5);
        thinking654 thinking6542 = new thinking654();
        service.execute(thinking654);
        service.execute(thinking6541);
        service.shutdown();
    }
}

class Thinking1124 implements Callable<String> {

    private int id;

    public Thinking1124(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "id: " + this.id;
    }
}

class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Thinking1124 thinking1124 = new Thinking1124(10);
        Future<String> future = service.submit(thinking1124);
        while (true){
            System.out.println(future.isDone());
            if(future.isDone()){
                System.out.println(future.get());
                break;
            }
        }
    }
}