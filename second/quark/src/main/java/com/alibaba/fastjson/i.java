package com.alibaba.fastjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public class i<T> {
    protected final Type a = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public final Type a() {
        return this.a;
    }
}
