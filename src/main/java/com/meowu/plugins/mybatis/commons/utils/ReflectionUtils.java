package com.meowu.plugins.mybatis.commons.utils;

import com.meowu.commons.common.utils.AssertUtils;
import com.meowu.commons.common.utils.StringUtils;
import com.meowu.plugins.mybatis.commons.security.exception.ReflectionException;

import java.lang.annotation.Annotation;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

public class ReflectionUtils{

    private ReflectionUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static <T, R> Field getField(Function<T, R> function){
        AssertUtils.isNotNull(function, "Getter function must not be null");

        try{
            // set access
            Method method = function.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);

            // get name
            SerializedLambda lambda     = (SerializedLambda) method.invoke(function);
            String           methodName = lambda.getImplMethodName();
            String           className  = lambda.getImplClass().replace("/", ".");

            // field name
            String fieldName;

            if(methodName.startsWith("get") && methodName.length() > 3){
                fieldName = StringUtils.uncapitalize(methodName.substring(3));

            }else if(methodName.startsWith("is") && methodName.length() > 2){
                fieldName = StringUtils.uncapitalize(methodName.substring(2));

            }else if(methodName.startsWith("lambda$")){
                throw new ReflectionException("Function cannot be lambda");

            }else{
                throw new ReflectionException("Function should be call getter");
            }

            if(StringUtils.isEmpty(fieldName)){
                throw new ReflectionException("Field name is null");
            }

            return org.springframework.util.ReflectionUtils.findField(Class.forName(className), fieldName);
        }catch(Exception e){
            throw new ReflectionException(e.getMessage(), e);
        }
    }

    public static <T extends Annotation, R> T getAnnotation(Class<R> objectType, Class<T> annotationType){
        AssertUtils.isNotNull(objectType, "Object type must not be null");
        AssertUtils.isNotNull(annotationType, "Annotation type must not be null");

        return objectType.getAnnotation(annotationType);
    }

    public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotationType){
        AssertUtils.isNotNull(field, "Field must not be null");
        AssertUtils.isNotNull(annotationType, "Annotation type must not be null");

        return field.getAnnotation(annotationType);
    }
}
