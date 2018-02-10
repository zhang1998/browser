package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.a.e;
import com.alibaba.fastjson.b.z;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ProGuard */
public @interface JSONField {
    boolean deserialize() default true;

    String format() default "";

    String name() default "";

    int ordinal() default 0;

    e[] parseFeatures() default {};

    boolean serialize() default true;

    z[] serialzeFeatures() default {};
}
