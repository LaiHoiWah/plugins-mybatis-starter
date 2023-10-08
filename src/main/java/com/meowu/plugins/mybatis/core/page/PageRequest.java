package com.meowu.plugins.mybatis.core.page;

import com.meowu.commons.common.utils.ObjectUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest{

    @Getter
    private long pageNumber;
    @Getter
    private long pageSize;

    public PageRequest(){
        this.pageNumber = 1;
        this.pageSize   = 10;
    }

    public PageRequest(Long pageNumber, Long pageSize){
        this.pageNumber = ObjectUtils.isNull(pageNumber) ? 1 : pageNumber;
        this.pageSize   = ObjectUtils.isNull(pageSize) ? 10 : pageSize;
    }

    public long getOffset(){
        return (getPageNumber() - 1) * getPageSize();
    }
}
