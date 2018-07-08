package com.tachai.example.singleton;

import com.tachai.annoations.ThreadSafe;

/**
 * Created by @Author tachai
 * date 2018/7/8 23:15
 *
 * @Email 1206966083@qq.com
 */
//饿汉模式
    //在类装载的使用时进行创建
@ThreadSafe
public class SingletonExample2 {
    //私有构造函数
    private SingletonExample2(){

        //如果在构造放法中加入过多的处理可能会引起性能问题
    }
    //单例对象
    private static SingletonExample2 istance = new SingletonExample2();
    //静态的工厂方法
    public static SingletonExample2 getIstance(){
        return istance;
    }
}
