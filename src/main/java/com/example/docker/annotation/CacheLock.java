package com.example.docker.annotation;

import java.lang.annotation.*;

/**
 * @author linyongjin
 * @date 2019/7/15 16:48
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    String lockName() default "";

    long timeout() default 10000L;
}
