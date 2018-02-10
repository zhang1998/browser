package com.alibaba.analytics.core.f;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.alibaba.analytics.core.c.i;
import com.alibaba.fastjson.a;
import java.util.HashMap;

/* compiled from: ProGuard */
final class d implements Runnable {
    int a = 0;
    final /* synthetic */ f b;

    d(f fVar) {
        this.b = fVar;
    }

    public final void run() {
        try {
            double availableBytes;
            int a = this.b.a.a();
            double c = this.b.a.c();
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            if (VERSION.SDK_INT >= 18) {
                availableBytes = (((double) statFs.getAvailableBytes()) / 1024.0d) / 1024.0d;
            } else {
                availableBytes = (((double) statFs.getFreeBytes()) / 1024.0d) / 1024.0d;
            }
            Object hashMap = new HashMap();
            hashMap.put("min", Integer.valueOf(this.a));
            hashMap.put("dbLeft", Integer.valueOf(a));
            hashMap.put("dbFileSize", Double.valueOf(c));
            hashMap.put("freeSize", Double.valueOf(availableBytes));
            f.c.a(i.a(i.e, a.a(hashMap), Double.valueOf(1.0d)));
        } catch (Throwable th) {
        }
    }
}
