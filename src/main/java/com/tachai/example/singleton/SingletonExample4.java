package com.tachai.example.singleton;

import com.tachai.annoations.Recommend;
import com.tachai.annoations.ThreadSafe;

/**
 * Created by @Author tachai
 * date 2018/7/8 23:15
 *
 * @Email 1206966083@qq.com
 */
// 使用静态代码块的方式
@ThreadSafe
public class SingletonExample4 {
    //私有构造函数
    private SingletonExample4(){

        //如果在构造放法中加入过多的处理可能会引起性能问题
    }
    //单例对象
    private static SingletonExample4 istance = null;

    static {
        istance = new SingletonExample4();
    }

    //静态的工厂方法
    public static SingletonExample4 getIstance(){
        return istance;
    }

}
