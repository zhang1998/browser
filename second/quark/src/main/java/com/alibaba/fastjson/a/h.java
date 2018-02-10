package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.e;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
final class h implements e {
    public static final h a = new h();

    h() {
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return cVar.a(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        Collection arrayList = new ArrayList();
        cVar.a(genericComponentType, arrayList);
        if (!(genericComponentType instanceof Class)) {
            return arrayList.toArray();
        }
        Object[] objArr = (Object[]) Array.newInstance((Class) genericComponentType, arrayList.size());
        arrayList.toArray(objArr);
        return objArr;
    }
}
