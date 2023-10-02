package com.meowu.plugins.mybatis.core.mysql.entity;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Query{

    // selection
    private List<String> selections = Lists.newArrayList();

    // condition
    private List<Criterion> conditions = Lists.newArrayList();

    public Query select(String... selection){
        selections.addAll(Arrays.stream(selection).collect(Collectors.toList()));
        return this;
    }

    public Query select(String selection){
        selections.add(selection);
        return this;
    }

    public Query where(Criterion... criterion){
        conditions.addAll(Arrays.stream(criterion).collect(Collectors.toList()));
        return this;
    }

    public Query where(Criterion criterion){
        conditions.add(criterion);
        return this;
    }

    public List<String> getSelections(){
        return this.selections;
    }

    public List<Criterion> getConditions(){
        return this.conditions;
    }
}
