package com.taobao.weex;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Looper;
import com.taobao.weex.a.e;
import com.taobao.weex.a.g;
import com.taobao.weex.a.h;
import com.taobao.weex.a.j;
import com.taobao.weex.a.k;
import com.taobao.weex.a.l;
import com.taobao.weex.a.n;
import com.taobao.weex.a.o;
import com.taobao.weex.b.c.i;
import com.taobao.weex.b.d.c;
import com.taobao.weex.bridge.s;
import com.taobao.weex.bridge.z;
import com.taobao.weex.c.ab;
import com.taobao.weex.common.t;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.m;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public class ad {
    private static volatile ad r;
    private static AtomicInteger s = new AtomicInteger(0);
    public final ab a;
    public s b;
    public m c;
    public n d;
    k e;
    com.taobao.weex.a.m f;
    public g g;
    j h;
    h i;
    public l j;
    i k;
    public g l;
    o m;
    c n;
    public z o;
    public boolean p;
    public f q;

    private ad() {
        this(new m());
    }

    private ad(m mVar) {
        this.p = true;
        this.c = mVar;
        this.a = new ab(this.c);
        this.b = s.a();
    }

    public static ad a() {
        if (r == null) {
            synchronized (ad.class) {
                if (r == null) {
                    r = new ad();
                }
            }
        }
        return r;
    }

    public static int a(String str) {
        ac b = a().b(str);
        if (b == null) {
            return 750;
        }
        return b.o;
    }

    @Nullable
    public final ac b(String str) {
        return str == null ? null : this.c.b(str);
    }

    public final void a(Runnable runnable, long j) {
        this.c.a(w.a(runnable), j);
    }

    @Deprecated
    public final void a(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        if (!i.c() || Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            this.b.a(str, str2, str3, (Map) map, (Map) map2);
            return;
        }
        throw new t("[WXSDKManager]  fireEvent error");
    }

    static String b() {
        return String.valueOf(s.incrementAndGet());
    }

    @NonNull
    public final j c() {
        if (this.h == null) {
            this.h = new e();
        }
        return this.h;
    }
}
