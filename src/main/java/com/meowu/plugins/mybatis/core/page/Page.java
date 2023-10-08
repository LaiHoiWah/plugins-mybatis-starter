package com.meowu.plugins.mybatis.core.page;

import com.meowu.commons.common.utils.CollectionUtils;
import com.meowu.commons.common.utils.ObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page<T>{

    private List<T>     content;
    private Long        total;
    private PageRequest pageRequest;

    public Page(List<T> content, Long total, PageRequest pageRequest){
        this.content     = CollectionUtils.isEmpty(content) ? CollectionUtils.emptyList() : content;
        this.total       = ObjectUtils.isNull(total) ? 0L : total;
        this.pageRequest = ObjectUtils.isNull(pageRequest) ? new PageRequest() : pageRequest;
    }

    public boolean hasNext(){
        return getPageRequest().getOffset() + getContent().size() < getTotal();
    }
}
