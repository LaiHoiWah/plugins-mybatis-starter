package com.meowu.plugins.mybatis.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Page<T>{

    private List<T>     content;
    private Long        total;
    private PageRequest pageRequest;

    public Page(List<T> content, Long total, PageRequest pageRequest){
        this.content     = CollectionUtils.isEmpty(content) ? new ArrayList() : content;
        this.total       = total == null ? 0L : total;
        this.pageRequest = pageRequest;
    }

    public abstract boolean hasNext();
}
