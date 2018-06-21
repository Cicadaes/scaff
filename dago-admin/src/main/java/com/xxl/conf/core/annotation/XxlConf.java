package com.xxl.conf.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * xxl conf annotaion  (only support filed)
 *
 * @author xuxueli 2018-02-04 00:34:30
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XxlConf {

    /**
     * conf key
     *
     * @return
     */
    String value();

    /**
     * conf default value
     *
     * @return
     */
    String defaultValue() default "";

    /**
     *  whether you need a callback refresh, when the value changes.
     *
     * @return
     */
    boolean callback() default true;
}