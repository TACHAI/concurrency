package com.tachai.example.singleton;

import com.tachai.annoations.Recommend;
import com.tachai.annoations.ThreadSafe;

/**
 * Created by @Author tachai
 * date 2018/7/8 23:15
 *
 * @Email 1206966083@qq.com
 */
// 使用枚举的方式
@ThreadSafe
@Recommend
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){

        //如果在构造放法中加入过多的处理可能会引起性能问题
    }
    //单例对象
    private static SingletonExample3 istance = new SingletonExample3();
    //静态的工厂方法
    public static SingletonExample3 getIstance(){

        return Singleton.INSTANCE.getSingleton();
    }


    private enum Singleton {
        INSTANCE;

        private  SingletonExample3 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample3();
        }

        public SingletonExample3 getSingleton(){
            return singleton;
        }
    }
}
