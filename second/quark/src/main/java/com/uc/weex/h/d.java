package com.uc.weex.h;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.common.q;
import com.taobao.weex.common.w;
import com.taobao.weex.i;
import com.uc.weex.b;
import com.uc.weex.c;
import java.lang.reflect.Constructor;
import java.util.concurrent.Semaphore;

/* compiled from: ProGuard */
final class d extends o implements b {
    private static w j = new w("HotReloadWeexPageThread");
    private String a;
    private c i;

    public d(Context context) {
        super(context);
        if (i.c()) {
            try {
                Class cls = Class.forName("com.uc.weex.HotRefreshManager");
                if (cls != null) {
                    Constructor constructor = cls.getConstructor(new Class[]{b.class});
                    Semaphore semaphore = new Semaphore(0);
                    j.a.post(new c(this, constructor, semaphore));
                    semaphore.acquire();
                }
            } catch (Exception e) {
            }
        }
    }

    public final void a(String str) {
        if (!this.b.i) {
            this.a = str;
            this.b.b(this.d.b, str, this.d.d, this.d.f, q.APPEND_ASYNC);
            i.c();
        }
    }

    public final void d() {
        super.d();
        i.c();
    }

    public final void c() {
        if (!this.b.i && i.c()) {
            e();
            if (!TextUtils.isEmpty(this.a) && this.d != null) {
                this.b.b(this.d.b, this.a, this.d.d, this.d.f, q.APPEND_ASYNC);
            }
        }
    }
}
