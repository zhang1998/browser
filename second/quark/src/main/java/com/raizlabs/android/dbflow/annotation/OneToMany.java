package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface OneToMany {
    boolean efficientMethods() default true;

    boolean isVariablePrivate() default false;

    d[] methods() default {d.LOAD};

    String variableName() default "";
}
