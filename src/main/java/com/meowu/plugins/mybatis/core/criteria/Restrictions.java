package com.meowu.plugins.mybatis.core.criteria;

import com.meowu.commons.common.utils.AssertUtils;
import com.meowu.commons.common.utils.ObjectUtils;
import com.meowu.commons.common.utils.StringUtils;
import com.meowu.plugins.mybatis.commons.security.stereotype.Column;
import com.meowu.plugins.mybatis.commons.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

public class Restrictions{

    public static <T, R> Criterion select(Function<T, R> function){
        return new Criterion(field(function));
    }

    public static <T, R> Criterion count(Function<T, R> function){
        return new Criterion(field(function)).count();
    }

    public static <T, R> Criterion eq(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).equal(value);
    }

    public static <T, R> Criterion ne(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).notEqual(value);
    }

    public static <T, R> Criterion lt(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).lessThan(value);
    }

    public static <T, R> Criterion le(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).lessAndEqual(value);
    }

    public static <T, R> Criterion gt(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).greatThan(value);
    }

    public static <T, R> Criterion ge(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).greatAndEqual(value);
    }

    public static <T, R> Criterion like(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).like(value);
    }

    public static <T, R> Criterion notLike(Function<T, R> function, Object value){
        AssertUtils.isNotNull(value, "Value must not be null");

        return new Criterion(field(function)).notLike(value);
    }

    public static <T, R> Criterion between(Function<T, R> function, Object min, Object max){
        AssertUtils.isTrue(ObjectUtils.isNotNull(min) && ObjectUtils.isNotNull(max), "Value must not be null");

        return new Criterion(field(function)).between(min, max);
    }

    public static <T, R> Criterion notBetween(Function<T, R> function, Object min, Object max){
        AssertUtils.isTrue(ObjectUtils.isNotNull(min) && ObjectUtils.isNotNull(max), "Value must not be null");

        return new Criterion(field(function)).notBetween(min, max);
    }

    public static <T, R> Criterion in(Function<T, R> function, Object... value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion(field(function)).in(value);
    }

    public static <T, R> Criterion in(Function<T, R> function, List<Object> value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion(field(function)).in(value);
    }

    public static <T, R> Criterion notIn(Function<T, R> function, Object... value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion(field(function)).notIn(value);
    }

    public static <T, R> Criterion notIn(Function<T, R> function, List<Object> value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion(field(function)).notIn(value);
    }

    public static <T, R> Criterion isNull(Function<T, R> function){
        return new Criterion(field(function)).isNull();
    }

    public static <T, R> Criterion isNotNull(Function<T, R> function){
        return new Criterion(field(function)).isNotNull();
    }

    public static <T, R> Criterion regexp(Function<T, R> function, String pattern){
        AssertUtils.isNotBlank(pattern, "Pattern must not be null");

        return new Criterion(field(function)).regexp(pattern);
    }

    public static Criterion and(Criterion... value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion().and(value);
    }

    public static Criterion or(Criterion... value){
        AssertUtils.isNotEmpty(value, "Value must not be null");

        return new Criterion().or(value);
    }

    public static Criterion limit(long offset, long size){
        AssertUtils.isTrue(offset >= 0, "Offset must be greater than or equal to zero");
        AssertUtils.isTrue(size > 0, "Size must be greater than zero");

        return new Criterion().limit(offset, size);
    }

    public static <T, R> Criterion asc(Function<T, R> function){
        return new Criterion(field(function)).asc();
    }

    public static <T, R> Criterion desc(Function<T, R> function){
        return new Criterion(field(function)).desc();
    }

    private static <T, R> String field(Function<T, R> function){
        Field  field  = ReflectionUtils.getField(function);
        Column column = ReflectionUtils.getAnnotation(field, Column.class);

        if(ObjectUtils.isNull(column)){
            return StringUtils.toUnderscoreCase(field.getName());
        }

        return StringUtils.toUnderscoreCase(column.value());
    }
}
