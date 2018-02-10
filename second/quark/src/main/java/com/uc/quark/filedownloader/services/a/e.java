package com.uc.quark.filedownloader.services.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.uc.quark.filedownloader.f.l;
import com.uc.quark.filedownloader.services.t;
import java.io.IOException;

/* compiled from: ProGuard */
public final class e extends Handler {
    e(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        l lVar;
        t tVar;
        switch (message.what) {
            case 1:
                lVar = (l) message.obj;
                tVar = (t) lVar.c();
                try {
                    lVar.b();
                    tVar.a(lVar.d(), lVar);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 3:
                lVar = (l) message.obj;
                tVar = (t) lVar.c();
                try {
                    lVar.b();
                    tVar.a(lVar.d());
                    tVar.b();
                    return;
                } catch (IOException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
