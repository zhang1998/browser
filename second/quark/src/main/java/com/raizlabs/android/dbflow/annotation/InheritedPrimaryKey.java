package com.raizlabs.android.dbflow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ProGuard */
public @interface InheritedPrimaryKey {
    Column column();

    String fieldName();

    PrimaryKey primaryKey();
}
