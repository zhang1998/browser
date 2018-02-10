package com.uc.sync.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ProGuard */
public @interface JsonName {
    Class listParameterType() default Object.class;

    String value() default "";
}
