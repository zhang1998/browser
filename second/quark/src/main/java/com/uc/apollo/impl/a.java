package com.uc.apollo.impl;

import android.net.Uri;
import com.uc.apollo.Settings.Provider;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class a implements Provider {
    private Object a;
    private Method b;
    private Method c;
    private Method d;
    private Method e;
    private Method f;
    private Method g;

    public static Provider a(Object obj) {
        Provider aVar = new a(obj);
        if (aVar.a()) {
            return aVar;
        }
        return null;
    }

    private a(Object obj) {
        this.a = obj;
    }

    private boolean a() {
        try {
            Class cls = this.a.getClass();
            this.b = ReflectUtil.getMethod2(cls, "getStringValue", String.class);
            this.c = ReflectUtil.getMethod2(cls, "getIntValue", String.class);
            this.d = ReflectUtil.getMethod2(cls, "getFloatValue", String.class);
            this.e = ReflectUtil.getMethod2(cls, "getBoolValue", String.class);
            this.f = ReflectUtil.getMethod2(cls, "getCookie", Uri.class);
            this.g = ReflectUtil.getMethod2(cls, "getUserAgent", Uri.class);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public final String getStringValue(String str) {
        return (String) ReflectUtil.call(String.class, this.a, this.b, str);
    }

    public final int getIntValue(String str) {
        return ((Integer) ReflectUtil.call(Integer.TYPE, this.a, this.c, str)).intValue();
    }

    public final float getFloatValue(String str) {
        return ((Float) ReflectUtil.call(Float.TYPE, this.a, this.d, str)).floatValue();
    }

    public final boolean getBoolValue(String str) {
        return ((Boolean) ReflectUtil.call(Boolean.TYPE, this.a, this.e, str)).booleanValue();
    }

    public final String getCookie(Uri uri) {
        return (String) ReflectUtil.call(String.class, this.a, this.f, uri);
    }

    public final String getUserAgent(Uri uri) {
        return (String) ReflectUtil.call(String.class, this.a, this.g, uri);
    }
}
