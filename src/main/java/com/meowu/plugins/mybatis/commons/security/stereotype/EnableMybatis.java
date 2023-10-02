package com.meowu.plugins.mybatis.commons.security.stereotype;

import com.meowu.plugins.mybatis.commons.config.MybatisConfig;
import org.springframework.context.annotation.Import;

@Import(value = MybatisConfig.class)
public @interface EnableMybatis{

}
