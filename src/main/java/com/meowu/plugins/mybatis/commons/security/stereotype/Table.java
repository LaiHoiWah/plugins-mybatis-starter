package com.meowu.plugins.mybatis.commons.security.stereotype;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table{

    String value();
}
