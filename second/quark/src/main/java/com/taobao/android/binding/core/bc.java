package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.view.animation.AnimationUtils;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class bc extends b implements c {
    private long h = 0;
    private f i;
    private boolean j = false;

    bc(@NonNull ac acVar) {
        super(acVar);
        if (this.i == null) {
            this.i = f.c();
        } else {
            this.i.a();
        }
    }

    public final boolean a(@NonNull String str, @NonNull String str2) {
        return true;
    }

    public final void a(String str) {
    }

    public final void a(@NonNull String str, @Nullable Map<String, Object> map, @Nullable av avVar, @NonNull List<Map<String, Object>> list, @Nullable c cVar) {
        super.a(str, map, avVar, list, cVar);
        if (this.i == null) {
            this.i = f.c();
        }
        a("start", 0);
        this.i.a();
        this.i.a(this);
    }

    public final boolean b(@NonNull String str, @NonNull String str2) {
        a("end", System.currentTimeMillis() - this.h);
        a();
        if (this.i != null) {
            this.i.a();
        }
        this.h = 0;
        return true;
    }

    public final void b() {
        a();
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
        this.h = 0;
    }

    protected final void a(@NonNull Map<String, Object> map) {
        a("exit", (long) ((Double) map.get("t")).doubleValue());
        if (this.i != null) {
            this.i.a();
        }
        this.h = 0;
    }

    private void a(String str, long j) {
        if (this.b != null) {
            Map hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("t", Long.valueOf(j));
            this.b.b(hashMap);
            if (i.c()) {
                WXLogUtils.d("ExpressionBinding", ">>>>>>>>>>>fire event:(" + str + "," + j + ")");
            }
        }
    }

    public final void a_() {
        long j = 0;
        if (this.h == 0) {
            this.h = AnimationUtils.currentAnimationTimeMillis();
            this.j = false;
        } else {
            j = AnimationUtils.currentAnimationTimeMillis() - this.h;
        }
        try {
            ci.a(this.c, (double) j);
            if (!this.j) {
                a(this.a, this.c, "timing");
            }
            this.j = a(this.f, this.c);
        } catch (Exception e) {
            WXLogUtils.e("ExpressionBinding", "runtime error\n" + e.getMessage());
        }
    }

    public final void c() {
    }

    public final void d() {
    }
}
