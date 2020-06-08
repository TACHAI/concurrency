package com.tachai.lock;

import java.util.concurrent.Callable;

/**
 * Create by tachai on 2020-06-03 11:10
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class LoadFileTask implements Callable {

    private String name;

    public LoadFileTask(String name){
        this.name=name;
    }

    public String get(){
        return name;
    }


    @Override
    public Object call() throws Exception {
        System.out.println(name+":loadFileTask");
        this.notify();
        return null;
    }
}
