package com.example.docker.annotation;

import java.lang.annotation.*;

/**
 * @author linyongjin
 * @date 2019/7/15 17:09
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParameter {
    String parameterName() default "";
}
