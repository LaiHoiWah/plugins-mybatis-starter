package com.meowu.plugins.mybatis.commons.config;

import org.springframework.beans.factory.annotation.Value;

public class MybatisConfig{

    @Value("${plugins.mybatis.dialect}")
    private String dialect;
}
