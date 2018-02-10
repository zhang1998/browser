package com.taobao.weex.ui;

import android.util.Pair;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.a;
import com.taobao.weex.bridge.d;
import com.taobao.weex.c.ae;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class f implements b {
    private final Class<? extends ab> a;
    private Map<String, a> b;
    private Map<String, a> c;
    private a d;

    public f(Class<? extends ab> cls) {
        this(cls, new e(cls));
    }

    public f(Class<? extends ab> cls, a aVar) {
        this.a = cls;
        this.d = aVar;
    }

    public final void b() {
        Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            if (!(annotation instanceof Component)) {
                i++;
            } else if (!((Component) annotation).lazyload() && this.c == null) {
                c();
                return;
            } else {
                return;
            }
        }
    }

    private synchronized void c() {
        if (i.c()) {
            WXLogUtils.d("SimpleComponentHolder", "Generate Component:" + this.a.getSimpleName());
        }
        Pair a = a(this.a);
        this.b = (Map) a.first;
        this.c = (Map) a.second;
    }

    private static Pair<Map<String, a>, Map<String, a>> a(Class cls) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        try {
            for (Method method : cls.getMethods()) {
                try {
                    for (Annotation annotation : method.getDeclaredAnnotations()) {
                        if (annotation != null) {
                            if (annotation instanceof WXComponentProp) {
                                hashMap.put(((WXComponentProp) annotation).name(), new d(method, true));
                                break;
                            } else if (annotation instanceof JSMethod) {
                                JSMethod jSMethod = (JSMethod) annotation;
                                Object alias = jSMethod.alias();
                                if ("_".equals(alias)) {
                                    alias = method.getName();
                                }
                                hashMap2.put(alias, new d(method, jSMethod.uiThread()));
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IncompatibleClassChangeError e2) {
                }
            }
        } catch (IndexOutOfBoundsException e3) {
        }
        return new Pair(hashMap, hashMap2);
    }

    public final synchronized ab a(ac acVar, ae aeVar, bv bvVar) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ab a;
        a = this.d.a(acVar, aeVar, bvVar);
        a.bindHolder(this);
        return a;
    }

    public final synchronized a b(String str) {
        if (this.b == null) {
            c();
        }
        return (a) this.b.get(str);
    }

    public final a a(String str) {
        if (this.c == null) {
            c();
        }
        return (a) this.c.get(str);
    }

    public final String[] a() {
        if (this.c == null) {
            c();
        }
        Set keySet = this.c.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }
}
