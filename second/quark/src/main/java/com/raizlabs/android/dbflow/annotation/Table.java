package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface Table {
    boolean allFields() default false;

    boolean assignDefaultValuesFromCursor() default true;

    int cacheSize() default 25;

    boolean cachingEnabled() default false;

    Class<?> database();

    IndexGroup[] indexGroups() default {};

    InheritedColumn[] inheritedColumns() default {};

    InheritedPrimaryKey[] inheritedPrimaryKeys() default {};

    b insertConflict() default b.NONE;

    String name() default "";

    boolean orderedCursorLookUp() default false;

    b primaryKeyConflict() default b.NONE;

    UniqueGroup[] uniqueColumnGroups() default {};

    b updateConflict() default b.NONE;

    boolean useBooleanGetterSetters() default true;
}
