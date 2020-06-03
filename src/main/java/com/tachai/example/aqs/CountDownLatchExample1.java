package com.tachai.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by tachai on 2019-11-07 16:23
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class CountDownLatchExample1 {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(100);

        for(int i=0;i<100;i++){
            final int threadNum= i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("finish");
        executorService.shutdown();
    }


    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("current:"+threadNum);
        Thread.sleep(100);
    }
}
