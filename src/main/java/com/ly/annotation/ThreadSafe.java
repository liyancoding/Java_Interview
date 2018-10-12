package com.ly.annotation;

import com.sun.org.apache.regexp.internal.RE;
import org.codehaus.jackson.annotate.JsonSubTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:30 2018/10/12
 * @Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
