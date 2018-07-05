package com.tachai.example.atomic;

import com.tachai.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by @Author tachai
 * date 2018/7/3 23:02
 *
 * @Email 1206966083@qq.com
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static LongAdder count = new LongAdder();

    public static void main(String[] args)throws Exception {
        ExecutorService excutorService = Executors.newCachedThreadPool();
        //信号量，当前线程最大并发量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            excutorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            countDownLatch.await();
            excutorService.shutdown();
            log.info("count:{}",count);
        }catch (Exception e){
            log.error(e.getMessage());
        }


    }

    private static void add(){
        //先做操作再得到值
        count.increment();

        //先得到值再做操作
//        count.getAndIncrement();
    }
}
