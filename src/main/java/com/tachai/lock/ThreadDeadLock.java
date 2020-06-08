package com.tachai.lock;

import java.util.concurrent.*;

/**
 * Create by tachai on 2020-06-03 11:03
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ThreadDeadLock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String>{
        @Override
        public String call() throws Exception{
            Future<String> header ,footer;
            header = (Future<String>) exec.submit(new LoadFileTask("headder.html"));
            footer = (Future<String>) exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            //将发生死锁---由于任务在等待子任务的结果
            return header.get()+page+footer.get();
        }
    }

    public String renderBody(){
        return "======";
    }

}
