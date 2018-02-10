package com.taobao.weex.c.a;

import android.mini.support.annotation.NonNull;
import com.alibaba.fastjson.b;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.a;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.q;
import com.taobao.weex.common.o;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class p implements d, com.taobao.weex.c.p {
    private o a;
    private b b;
    private a c;

    public p(@NonNull o oVar, @NonNull b bVar, @NonNull a aVar) {
        this.a = oVar;
        this.b = bVar;
        this.c = aVar;
    }

    public final void a(e eVar) {
        eVar.a((com.taobao.weex.c.p) this);
    }

    public final void a(q qVar) {
        if (qVar != null) {
            ac a = qVar.a();
            if (a != null) {
                try {
                    a.j.a(this.a, this.c, this.b);
                } catch (Throwable e) {
                    WXLogUtils.e("callModuleMethod >>> invoke module:" + this.a.getClass().getSimpleName() + " failed. ", e);
                }
            }
        }
    }
}
