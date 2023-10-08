package com.meowu.plugins.mybatis.core.criteria;

import com.google.common.base.Joiner;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Criterion{

    private String field;
    private String operator;
    private Object value;
    private Object secondValue;

    private boolean singleValue    = false;
    private boolean twinValue      = false;
    private boolean listValue      = false;
    private boolean noValue        = false;
    private boolean criterionValue = false;
    private boolean limitValue     = false;
    private boolean orderByValue   = false;
    private boolean groupByValue   = false;

    public Criterion(){

    }

    public Criterion(String field){
        this.field = field;
    }

    public Criterion(String... fields){
        this.field = Joiner.on(",").join(fields);
    }

    public Criterion equal(Object value){
        this.value       = value;
        this.operator    = Operator.EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion notEqual(Object value){
        this.value       = value;
        this.operator    = Operator.NOT_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion lessThan(Object value){
        this.value       = value;
        this.operator    = Operator.LESS_THAN;
        this.singleValue = true;

        return this;
    }

    public Criterion lessAndEqual(Object value){
        this.value       = value;
        this.operator    = Operator.LESS_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion greatThan(Object value){
        this.value       = value;
        this.operator    = Operator.GREAT_THAN;
        this.singleValue = true;

        return this;
    }

    public Criterion greatAndEqual(Object value){
        this.value       = value;
        this.operator    = Operator.GREAT_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion like(Object value){
        this.value       = "%" + value + "%";
        this.operator    = Operator.LIKE;
        this.singleValue = true;

        return this;
    }

    public Criterion notLike(Object value){
        this.value       = "%" + value + "%";
        this.operator    = Operator.NOT_LIKE;
        this.singleValue = true;

        return this;
    }

    public Criterion between(Object min, Object max){
        this.value       = min;
        this.secondValue = max;
        this.operator    = Operator.BETWEEN;
        this.twinValue   = true;

        return this;
    }

    public Criterion notBetween(Object min, Object max){
        this.value       = min;
        this.secondValue = max;
        this.operator    = Operator.NOT_BETWEEN;
        this.twinValue   = true;

        return this;
    }

    public Criterion in(Object... value){
        this.value     = Arrays.stream(value).collect(Collectors.toList());
        this.operator  = Operator.IN;
        this.listValue = true;

        return this;
    }

    public Criterion in(List<Object> value){
        this.value     = value;
        this.operator  = Operator.IN;
        this.listValue = true;

        return this;
    }

    public Criterion notIn(Object... value){
        this.value     = Arrays.stream(value).collect(Collectors.toList());
        this.operator  = Operator.NOT_IN;
        this.listValue = true;

        return this;
    }

    public Criterion notIn(List<Object> value){
        this.value     = value;
        this.operator  = Operator.NOT_IN;
        this.listValue = true;

        return this;
    }

    public Criterion isNull(){
        this.operator = Operator.IS_NULL;
        this.noValue  = true;

        return this;
    }

    public Criterion isNotNull(){
        this.operator = Operator.IS_NOT_NULL;
        this.noValue  = true;

        return this;
    }

    public Criterion regexp(Object value){
        this.value       = value;
        this.operator    = Operator.REGEXP;
        this.singleValue = true;

        return this;
    }

    public Criterion and(Criterion... value){
        this.value          = Arrays.stream(value).collect(Collectors.toList());
        this.operator       = Operator.AND;
        this.criterionValue = true;

        return this;
    }

    public Criterion and(List<Criterion> value){
        this.value          = value;
        this.operator       = Operator.AND;
        this.criterionValue = true;

        return this;
    }

    public Criterion or(Criterion... value){
        this.value          = Arrays.stream(value).collect(Collectors.toList());
        this.operator       = Operator.OR;
        this.criterionValue = true;

        return this;
    }

    public Criterion or(List<Criterion> value){
        this.value          = value;
        this.operator       = Operator.OR;
        this.criterionValue = true;

        return this;
    }

    public Criterion limit(long offset, long size){
        this.value       = offset;
        this.secondValue = size;
        this.operator    = Operator.LIMIT;
        this.limitValue  = true;

        return this;
    }

    public Criterion groupBy(Object... value){
        this.value        = Arrays.stream(value).collect(Collectors.toList());
        this.operator     = Operator.GROUP_BY;
        this.groupByValue = true;

        return this;
    }

    public Criterion groupBy(List<Object> value){
        this.value        = value;
        this.operator     = Operator.GROUP_BY;
        this.groupByValue = true;

        return this;
    }

    public Criterion asc(Object value){
        this.value        = value;
        this.operator     = Operator.ASC;
        this.orderByValue = true;

        return this;
    }

    public Criterion desc(Object value){
        this.value        = value;
        this.operator     = Operator.DESC;
        this.orderByValue = true;

        return this;
    }

    public Criterion orderBy(Criterion... value){
        this.value        = Arrays.stream(value).collect(Collectors.toList());
        this.operator     = Operator.ORDER_BY;
        this.orderByValue = true;

        return this;
    }
}
