package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface ManyToMany {
    boolean generateAutoIncrement() default true;

    String generatedTableClassName() default "";

    Class<?> referencedTable();

    String referencedTableColumnName() default "";

    boolean saveForeignKeyModels() default false;

    String thisTableColumnName() default "";
}
