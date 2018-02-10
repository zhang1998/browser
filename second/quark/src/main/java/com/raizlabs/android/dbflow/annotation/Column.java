package com.raizlabs.android.dbflow.annotation;

import com.raizlabs.android.dbflow.d.a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface Column {
    a collate() default a.NONE;

    String defaultValue() default "";

    String getterName() default "";

    int length() default -1;

    String name() default "";

    String setterName() default "";

    Class<? extends a> typeConverter() default a.class;
}
