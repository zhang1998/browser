package com.ucpro.feature.z.f.a;

import android.os.Handler;
import android.os.Message;
import com.uc.base.b.c.d;
import com.uc.base.b.c.i;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class b extends Handler {
    WeakReference<c> a;

    public b(c cVar) {
        this.a = new WeakReference(cVar);
    }

    public final void handleMessage(Message message) {
        if (this.a.get() != null) {
            switch (message.what) {
                case 1:
                    c cVar = (c) this.a.get();
                    i aVar = new a();
                    a aVar2 = cVar.b;
                    aVar.a(new d((byte) 2, cVar.b.l_(), null));
                    com.uc.browser.b.a("history", "input_history", aVar);
                    return;
                default:
                    return;
            }
        }
    }
}
