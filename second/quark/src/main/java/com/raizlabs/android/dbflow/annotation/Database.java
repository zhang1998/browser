package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface Database {
    boolean backupEnabled() default false;

    boolean consistencyCheckEnabled() default false;

    String databaseExtension() default "";

    boolean foreignKeyConstraintsEnforced() default false;

    String generatedClassSeparator() default "_";

    boolean inMemory() default false;

    b insertConflict() default b.NONE;

    String name() default "";

    b updateConflict() default b.NONE;

    int version();
}
