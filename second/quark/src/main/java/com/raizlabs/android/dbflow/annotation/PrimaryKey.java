package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface PrimaryKey {
    boolean autoincrement() default false;

    boolean quickCheckAutoIncrement() default false;

    boolean rowID() default false;
}
