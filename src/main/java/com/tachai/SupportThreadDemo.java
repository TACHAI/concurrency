package com.tachai;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Create by tachai on 2020-06-04 15:00
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class SupportThreadDemo {


    static int count = 0;

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("SupportThreadDemo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),namedThreadFactory,new ThreadPoolExecutor.DiscardOldestPolicy());
        int sum = 50000;
        CountDownLatch countDownLatch = new CountDownLatch(sum);
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < sum; i++) {
            pool.execute(() -> {
                        try {
                            semaphore.acquire();
                            doSomeThing();
                            System.out.println("count:"+count);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        } finally {
                            countDownLatch.countDown();
                            semaphore.release();
                        }
                    }
            );
        }

        try {
            countDownLatch.await();
            pool.shutdown();//gracefully shutdown
            System.out.println("总的count："+count);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {

        }

    }


    public synchronized static void doSomeThing() {
        count++;
    }
}
