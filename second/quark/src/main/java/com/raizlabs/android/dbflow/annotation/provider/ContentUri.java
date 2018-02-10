package com.raizlabs.android.dbflow.annotation.provider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface ContentUri {

    /* compiled from: ProGuard */
    public @interface PathSegment {
        String column();

        int segment();
    }

    boolean deleteEnabled() default true;

    boolean insertEnabled() default true;

    String path();

    boolean queryEnabled() default true;

    PathSegment[] segments() default {};

    String type();

    boolean updateEnabled() default true;
}
