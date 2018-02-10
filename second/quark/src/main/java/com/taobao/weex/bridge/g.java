package com.taobao.weex.bridge;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.taobao.weex.ad;
import com.taobao.weex.utils.w;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class g {
    private String a;

    public g(String str) {
        this.a = str;
    }

    public final Object a(Object obj, a aVar, b bVar) throws Exception {
        Type[] a = aVar.a();
        Object[] objArr = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            Type type = a[i];
            if (i < bVar.size()) {
                Object obj2 = bVar.get(i);
                if (type == e.class) {
                    objArr[i] = obj2;
                } else if (c.class != type) {
                    objArr[i] = w.a(type, obj2);
                } else if (obj2 instanceof String) {
                    objArr[i] = new h(this.a, (String) obj2);
                } else {
                    throw new Exception("Parameter type not match.");
                }
            } else if (type.getClass().isPrimitive()) {
                throw new Exception("[prepareArguments] method argument list not match.");
            } else {
                objArr[i] = null;
            }
        }
        if (!aVar.b()) {
            return aVar.a(obj, objArr);
        }
        ad.a().a(new f(this, aVar, obj, objArr), 0);
        return null;
    }
}
