package com.tachai.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by @Author tachai
 * date 2018/7/7 23:11
 *
 * @Email 1206966083@qq.com
 */
@Slf4j
public class SynchroizedExample1 {

    //修饰代码块
    public void test11(int j){
        synchronized (this){
            for(int i=0;i<10;i++){
                log.info("test1:{}--{}",j,i);
            }
        }
    }

    //修是方法
    public synchronized void test2(){
        for(int i=0;i<10;i++){
            log.info("test2:{}",i);
        }
    }

    public static void main(String[] args) {
        SynchroizedExample1 example1= new SynchroizedExample1();
        SynchroizedExample1 example2= new SynchroizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test11(1);
        });
        executorService.execute(()->{
            example2.test11(2);
        });
    }
}
