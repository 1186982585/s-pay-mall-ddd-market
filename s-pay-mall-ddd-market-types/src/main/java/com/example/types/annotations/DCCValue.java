package com.example.types.annotations;

import java.lang.annotation.*;

/**
 * @Author cxj
 * @Date 2025/9/9 11:24
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {

    String value() default "";

}
