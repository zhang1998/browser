package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface Unique {
    b onUniqueConflict() default b.FAIL;

    boolean unique() default true;

    int[] uniqueGroups() default {};
}
