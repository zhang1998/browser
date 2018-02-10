package com.uc.sync.e;

import android.os.Looper;
import android.os.Message;
import com.uc.sync.f.j;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
final class c extends e {
    final /* synthetic */ g a;

    c(g gVar, String str, Looper looper) {
        this.a = gVar;
        super(str, looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                g.a(this.a);
                return;
            case 4:
                g.a(this.a);
                return;
            case 5:
                g.a(this.a, (j) message.obj);
                return;
            case 6:
                g.b(this.a, (j) message.obj);
                return;
            default:
                return;
        }
    }
}
