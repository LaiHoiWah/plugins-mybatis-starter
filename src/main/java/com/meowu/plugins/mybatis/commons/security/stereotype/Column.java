package com.meowu.plugins.mybatis.commons.security.stereotype;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column{

    String value() default "";

    @AliasFor("value")
    String name() default "";
}
