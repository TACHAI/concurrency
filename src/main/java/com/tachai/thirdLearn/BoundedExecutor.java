package com.tachai.thirdLearn;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/**
 * Create by tachai on 2020-06-03 08:23
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class BoundedExecutor {
    private final Executor executor;
    private final Semaphore semaphore;


    public BoundedExecutor(Executor executor,int bound){
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable  command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();

                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (Exception e){
            semaphore.release();
        }

    }

}
