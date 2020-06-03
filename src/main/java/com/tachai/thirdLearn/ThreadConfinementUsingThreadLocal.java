package com.tachai.thirdLearn;

/**
 * 使用ThreadLocal 线程封闭
 * Create by tachai on 2020-06-03 09:54
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ThreadConfinementUsingThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> stringHolder= new ThreadLocal<>();

        Runnable runnable1=()->{
          stringHolder.set("Thread in runable1");
          try {
              Thread.sleep(5000);
              System.out.println(stringHolder.get());
          }catch (InterruptedException e){
              e.printStackTrace();
          }
        };



        Runnable runnable2 =()->{
            stringHolder.set("Thread in runable2");
            try {
                Thread.sleep(2000);
                stringHolder.set("Thread in runable2 changed");
                System.out.println(stringHolder.get());
            }catch (InterruptedException e){
                e.getMessage();
            }
        };


        Runnable runnable3=()->{
            stringHolder.set("Thread in runable3");
            try {
                Thread.sleep(5000);
                System.out.println(stringHolder.get());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);



        thread1.start();
        thread2.start();
        thread3.start();
    }
}
