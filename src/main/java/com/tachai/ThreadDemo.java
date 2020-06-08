package com.tachai;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by tachai on 2020-06-04 07:47
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ThreadDemo {
     static AtomicInteger count =new AtomicInteger(0);
    public static void main(String[] args) {

        Semaphore semaphore= new Semaphore(200);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final int sum =50000;
        final CountDownLatch countDownLatch = new CountDownLatch(sum);

        for(int i=0;i<sum;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                    semaphore.release();
                }

            });
        }
        try {
            countDownLatch.await();
            // 计数器全部减完后关闭线程池
            executorService.shutdown();
            System.out.println("count"+count.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }



    public  static void run(){
        count.incrementAndGet();

        System.out.println("这是："+count.get());
    }
}
