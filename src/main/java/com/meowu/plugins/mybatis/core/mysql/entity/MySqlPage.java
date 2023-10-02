package com.meowu.plugins.mybatis.core.mysql.entity;

import com.meowu.plugins.mybatis.core.domain.Page;

import java.util.List;

public class MySqlPage<T> extends Page{

    public MySqlPage(List<T> content, Long total, MySqlPageRequest pageRequest){
        super(content, total, pageRequest == null ? new MySqlPageRequest() : pageRequest);
    }

    @Override
    public boolean hasNext(){
        return getPageRequest().getOffset() + getContent().size() < getTotal();
    }
}
