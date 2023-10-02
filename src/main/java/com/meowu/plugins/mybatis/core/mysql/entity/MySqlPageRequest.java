package com.meowu.plugins.mybatis.core.mysql.entity;

import com.meowu.plugins.mybatis.core.domain.PageRequest;

public class MySqlPageRequest extends PageRequest{

    public MySqlPageRequest(){
        super();
    }

    public MySqlPageRequest(Long pageNumber, Long pageSize){
        super(pageNumber, pageSize);
    }

    @Override
    public long getOffset(){
        return (getPageNumber() - 1) * getPageSize();
    }
}
