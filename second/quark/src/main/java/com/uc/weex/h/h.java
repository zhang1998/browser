package com.uc.weex.h;

import java.util.Map;

/* compiled from: ProGuard */
public abstract class h {
    protected k a;

    private h() {
        this.a = new k();
    }

    public final h a(String str, Object obj) {
        this.a.a(str, obj);
        return this;
    }

    public final h a(Map<String, Object> map) {
        if (map != null) {
            this.a.a(map);
        }
        return this;
    }

    public final h a(boolean z) {
        this.a.g = z;
        return this;
    }

    public final h a() {
        this.a.i = true;
        return this;
    }

    public final k b() {
        return this.a;
    }
}
