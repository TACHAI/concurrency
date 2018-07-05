package com.tachai.example.atomic;

import com.tachai.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by @Author tachai
 * date 2018/7/3 23:02
 *
 * @Email 1206966083@qq.com
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //AtomicIntegerFieldUpdater原子性的更新某个实例的属性的值
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 example5= new AtomicExample5();

    public static void main(String[] args) {
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success:{}",example5.getCount());
        }
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success:{}",example5.getCount());
        }else {
            log.info("update failed,{}",example5.getCount());
        }
    }
}
