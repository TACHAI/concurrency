package com.tachai.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by @Author tachai
 * date 2018/7/2 23:18
 *
 * @Email 1206966083@qq.com
 */

/**
 * 标记【推荐的】类或者写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {
    String value() default "";
}
