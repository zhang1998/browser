package com.taobao.weex.c;

import android.os.Handler;
import android.os.Message;
import com.taobao.weex.common.t;
import com.taobao.weex.common.w;
import com.taobao.weex.i;
import com.taobao.weex.ui.m;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class ab {
    public w a = new w("WeeXDomThread", new z(this));
    public Handler b = this.a.a;
    public ConcurrentHashMap<String, m> c = new ConcurrentHashMap();
    private m d;

    public ab(m mVar) {
        this.d = mVar;
    }

    public final void a(Message message, long j) {
        if (message != null && this.b != null && this.a != null && this.a.a() && this.a.getLooper() != null) {
            this.b.sendMessageDelayed(message, j);
        }
    }

    public final void a(String str, d dVar) {
        e eVar = (e) this.c.get(str);
        if (eVar == null) {
            eVar = new m(str, this.d);
            this.c.put(str, eVar);
        }
        dVar.a(eVar);
    }

    public final void a(String str, d dVar, boolean z) {
        a(str, dVar, z, 0);
    }

    public final void a(String str, d dVar, boolean z, long j) {
        if (dVar != null) {
            Message obtain = Message.obtain();
            obtain.what = 254;
            ah ahVar = new ah();
            ahVar.a = str;
            ahVar.b = new ArrayList();
            ahVar.b.add(dVar);
            ahVar.b.add(Boolean.valueOf(z));
            obtain.obj = ahVar;
            a(obtain, j);
        }
    }

    final void a() {
        Object obj;
        if (!i.c() || Thread.currentThread().getId() == this.a.getId()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new t("dom operation must be done in dom thread");
        }
    }
}
