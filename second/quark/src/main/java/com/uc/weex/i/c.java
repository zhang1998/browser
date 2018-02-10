package com.uc.weex.i;

import android.content.Context;
import com.taobao.weex.a.m;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class c implements m {
    private d a;

    public c(Context context, ClassLoader classLoader, List<String> list, boolean z) {
        this.a = new d(context, classLoader, list, z);
    }

    public final void a(String str) {
        d dVar = this.a;
        dVar.a();
        try {
            dVar.a(System.mapLibraryName(str), 0);
            if (dVar.b != null) {
                new ScheduledThreadPoolExecutor(1).schedule(new g(dVar.b), 30, TimeUnit.SECONDS);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void b(String str) {
        this.a.a(str);
    }
}
