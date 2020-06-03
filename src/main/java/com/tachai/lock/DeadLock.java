package com.tachai.lock;

/**
 * Create by tachai on 2019-02-18 16:50
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class DeadLock {

    public static String obj1="obj1";
    public static String obj2="obj2";

    public static void main(String[] args) {
        Thread lock1 = new Thread(new Lock1());
        Thread lock2 = new Lock2();
        lock1.start();
        lock2.start();
    }
}


class Lock1 implements Runnable{

    @Override
    public void run() {

        try{
            System.out.println("lock1 is running");

            while (true){
                synchronized (DeadLock.obj1){
                    System.out.println("lock1 lock obj1");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj2){
                        System.out.println("lock1 lock obj2");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}


class Lock2 extends Thread{

    @Override
    public void run() {

        try{
            System.out.println("lock2 is running");

            while (true){
                synchronized (DeadLock.obj2){
                    System.out.println("lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj1){
                        System.out.println("lock2 lock obj1");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}