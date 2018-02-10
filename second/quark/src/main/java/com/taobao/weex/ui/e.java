package com.taobao.weex.ui;

import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.t;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ProGuard */
final class e implements a {
    private Constructor<? extends ab> a;
    private final Class<? extends ab> b;

    e(Class<? extends ab> cls) {
        this.b = cls;
    }

    public final ab a(ac acVar, ae aeVar, bv bvVar) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.a == null) {
            Constructor constructor;
            Class cls = this.b;
            try {
                constructor = cls.getConstructor(new Class[]{ac.class, ae.class, bv.class});
            } catch (NoSuchMethodException e) {
                WXLogUtils.d("ClazzComponentCreator", "Use deprecated component constructor");
                try {
                    constructor = cls.getConstructor(new Class[]{ac.class, ae.class, bv.class, Boolean.TYPE});
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = cls.getConstructor(new Class[]{ac.class, ae.class, bv.class, String.class, Boolean.TYPE});
                    } catch (NoSuchMethodException e3) {
                        throw new t("Can't find constructor of component.");
                    }
                }
            }
            this.a = constructor;
        }
        int length = this.a.getParameterTypes().length;
        if (length == 3) {
            return (ab) this.a.newInstance(new Object[]{acVar, aeVar, bvVar});
        } else if (length == 4) {
            return (ab) this.a.newInstance(new Object[]{acVar, aeVar, bvVar, Boolean.valueOf(false)});
        } else {
            return (ab) this.a.newInstance(new Object[]{acVar, aeVar, bvVar, acVar.e, Boolean.valueOf(bvVar.isLazy())});
        }
    }
}
