package com.uc.weex.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.taobao.weex.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class l {
    ArrayList<m> a;
    private volatile boolean b = false;
    private Context c;
    private List<String> d;

    public l(Context context, List<String> list) {
        this.c = context;
        this.d = list;
        this.a = new ArrayList();
    }

    public final synchronized void a(d dVar) {
        Object obj = 1;
        synchronized (this) {
            String str = System.getenv("LD_LIBRARY_PATH");
            if (str == null) {
                str = "/vendor/lib:/system/lib";
            }
            String[] split = str.split(":");
            for (String file : split) {
                this.a.add(new e(new File(file), 2, dVar));
            }
            if (this.c != null) {
                ApplicationInfo applicationInfo = this.c.getApplicationInfo();
                if ((applicationInfo.flags & 1) == 0 || (applicationInfo.flags & 128) != 0) {
                    obj = null;
                }
                if (obj != null) {
                    try {
                        this.a.add(0, new b(this.c, dVar));
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
                this.a.add(0, new e(new File(applicationInfo.nativeLibraryDir), 1, dVar));
                if (this.d != null && this.d.size() > 0) {
                    for (int size = this.d.size() - 1; size >= 0; size--) {
                        this.a.add(0, new e(new File((String) this.d.get(size)), 1, dVar));
                    }
                }
            }
            if (!this.b) {
                try {
                    String b = m.b();
                    boolean a = d.a(this.a, System.mapLibraryName("v8uc"));
                    boolean a2 = d.a(this.a, System.mapLibraryName("v9uc"));
                    boolean a3 = d.a(this.a, System.mapLibraryName(b));
                    if (!(((a || a2) && a3) || this.c == null)) {
                        this.a.add(0, new b(this.c, dVar));
                    }
                    this.b = true;
                } catch (Throwable th) {
                }
            }
        }
    }

    public final synchronized boolean a() {
        return this.b;
    }
}
