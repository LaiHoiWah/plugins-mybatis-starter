package com.meowu.plugins.mybatis.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageRequest{

    @Getter
    private long pageNumber;
    @Getter
    private long pageSize;

    public PageRequest(){
        this.pageNumber = 0;
        this.pageSize   = 10;
    }

    public PageRequest(Long pageNumber, Long pageSize){
        this.pageNumber = pageNumber == null ? 0 : pageNumber;
        this.pageSize   = pageSize == null ? 10 : pageSize;
    }

    public abstract long getOffset();
}
