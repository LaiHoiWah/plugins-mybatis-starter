package com.meowu.plugins.mybatis.core.criteria;

import com.google.common.collect.Lists;
import com.meowu.plugins.mybatis.commons.security.stereotype.Table;
import com.meowu.plugins.mybatis.commons.utils.ReflectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Query<T>{

    private String table;

    private final List<Criterion> selections = Lists.newArrayList();
    private final List<Criterion> conditions = Lists.newArrayList();
    private final List<Criterion> groupBy    = Lists.newArrayList();
    private final List<Criterion> orderBy    = Lists.newArrayList();

    public Query(Class<T> type){
        afterProperties(type);
    }

    private void afterProperties(Class<T> type){
        // get annotation
        Table annotation = ReflectionUtils.getAnnotation(type, Table.class);
        // get table name
        table = annotation.value();
    }

    public Query<T> select(Criterion... selection){
        if(selection.length > 1){
            selections.addAll(Arrays.stream(selection).collect(Collectors.toList()));
        }else{
            selections.add(selection[0]);
        }
        return this;
    }

    public Query<T> where(Criterion... criteria){
        if(criteria.length > 1){
            conditions.addAll(Arrays.stream(criteria).collect(Collectors.toList()));
        }else{
            conditions.add(criteria[0]);
        }
        return this;
    }

    public Query<T> groupBy(Criterion... groups){
        if(groups.length > 1){
            groupBy.addAll(Arrays.stream(groups).collect(Collectors.toList()));
        }else{
            groupBy.add(groups[0]);
        }
        return this;
    }

    public Query<T> sort(Criterion... criteria){
        if(criteria.length > 1){
            orderBy.addAll(Arrays.stream(criteria).collect(Collectors.toList()));
        }else{
            orderBy.add(criteria[0]);
        }
        return this;
    }

    public List<Criterion> getSelections(){
       return selections;
    }

    public List<Criterion> getConditions(){
        return conditions;
    }

    public List<Criterion> getGroupBy(){
        return groupBy;
    }

    public List<Criterion> getOrderBy(){
        return orderBy;
    }

    public String getTable(){
        return table;
    }
}
