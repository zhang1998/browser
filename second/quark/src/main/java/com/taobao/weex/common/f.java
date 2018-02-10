package com.taobao.weex.common;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.a;
import com.taobao.weex.bridge.d;
import com.taobao.weex.bridge.e;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class f<T extends o> implements e<T> {
    Class<T> a;
    Map<String, a> b;

    public f(Class<T> cls) {
        this.a = cls;
    }

    private void c() {
        if (i.c()) {
            WXLogUtils.d("TypeModuleFactory", "extractMethodNames:" + this.a.getSimpleName());
        }
        Map hashMap = new HashMap();
        try {
            for (Method method : this.a.getMethods()) {
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation != null) {
                        if (annotation instanceof JSMethod) {
                            JSMethod jSMethod = (JSMethod) annotation;
                            hashMap.put("_".equals(jSMethod.alias()) ? method.getName() : jSMethod.alias(), new d(method, jSMethod.uiThread()));
                        } else if (annotation instanceof WXModuleAnno) {
                            hashMap.put(method.getName(), new d(method, ((WXModuleAnno) annotation).runOnUIThread()));
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.b = hashMap;
    }

    public final T b() throws IllegalAccessException, InstantiationException {
        return (o) this.a.newInstance();
    }

    public final String[] a() {
        if (this.b == null) {
            c();
        }
        Set keySet = this.b.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public final a a(String str) {
        if (this.b == null) {
            c();
        }
        return (a) this.b.get(str);
    }
}
