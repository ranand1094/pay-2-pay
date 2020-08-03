package com.crosspay.rates.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.ElementKind;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableLog {

}
