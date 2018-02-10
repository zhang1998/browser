package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface ForeignKey {
    boolean deferred() default false;

    boolean deleteForeignKeyModel() default false;

    c onDelete() default c.NO_ACTION;

    c onUpdate() default c.NO_ACTION;

    ForeignKeyReference[] references() default {};

    boolean saveForeignKeyModel() default false;

    boolean stubbedRelationship() default false;

    Class<?> tableClass() default Object.class;
}
