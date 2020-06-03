package com.tachai;

import com.tachai.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by @Author tachai
 * date 2018/7/3 23:02
 *
 * @Email 1206966083@qq.com
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

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
            System.out.println("count:"+count);
//            log.info("count:{}",count);
        }catch (Exception e){
            System.out.println(e.getMessage());

//            log.error(e.getMessage());
        }


    }

    private static void add(){
        count++;
    }
}
