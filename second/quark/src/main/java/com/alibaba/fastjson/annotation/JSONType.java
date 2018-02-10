package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.a.e;
import com.alibaba.fastjson.b.z;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ProGuard */
public @interface JSONType {
    boolean alphabetic() default true;

    boolean asm() default true;

    String[] ignores() default {};

    Class<?> mappingTo() default Void.class;

    String[] orders() default {};

    e[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    z[] serialzeFeatures() default {};

    String typeName() default "";
}
