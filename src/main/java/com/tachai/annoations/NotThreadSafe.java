package com.tachai.annoations;

/**
 * Created by @Author tachai
 * date 2018/7/2 23:22
 *
 * @Email 1206966083@qq.com
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记【线程不安全】类或者写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
    String value() default "";
}

