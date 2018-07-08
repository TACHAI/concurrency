package com.tachai.example.singleton;

import com.tachai.annoations.NotRecommend;
import com.tachai.annoations.NotThreadSafe;
import com.tachai.annoations.ThreadSafe;

/**
 * Created by @Author tachai
 * date 2018/7/8 23:15
 *
 * @Email 1206966083@qq.com
 */
//懒汉模式 双重同步锁单例模式
@ThreadSafe
@NotRecommend
public class SingletonExample1 {
    //私有构造函数
    private SingletonExample1(){

    }
    //单例对象 voilatile + 双重检测机制来禁止指令重排
    private volatile static SingletonExample1 istance = null;
    //静态的工厂方法
    public static  SingletonExample1 getIstance(){
        if( null == istance){//双重检测机制
            synchronized(SingletonExample1.class){//同步锁
                if (istance == null){
                    istance = new SingletonExample1();
                }
            }
        }
        return istance;
    }
}
