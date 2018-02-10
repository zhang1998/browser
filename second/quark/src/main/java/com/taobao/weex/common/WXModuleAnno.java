package com.taobao.weex.common;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ProGuard */
public @interface WXModuleAnno {
    @Deprecated
    boolean moduleMethod() default true;

    boolean runOnUIThread() default true;
}
