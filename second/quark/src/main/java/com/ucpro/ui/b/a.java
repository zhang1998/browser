package com.ucpro.ui.b;

import android.os.Looper;
import android.os.Message;
import com.ucweb.common.util.e;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
class a extends e {
    WeakReference<e> a;

    a(Looper looper, e eVar) {
        super(a.class.getName(), looper);
        this.a = new WeakReference(eVar);
    }

    public void handleMessage(Message message) {
        e eVar = (e) this.a.get();
        if (eVar != null) {
            int i = message.what;
            if (i == 1) {
                if (!e.l.i) {
                    b bVar = (b) e.l.b.poll();
                    if (bVar != null) {
                        e.l.i = true;
                        e.a(eVar, bVar);
                    }
                }
            } else if (i == 2) {
                eVar.d();
            } else if (i == 0) {
                e.d(eVar);
            } else if (i == 3) {
                eVar.d();
            }
        }
    }
}
