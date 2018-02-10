package com.uc.quark.filedownloader;

import android.util.Log;
import com.uc.quark.filedownloader.e.j;

/* compiled from: ProGuard */
final class aq implements Runnable {
    final /* synthetic */ m a;

    aq(m mVar) {
        this.a = mVar;
    }

    public final void run() {
        if (j.a) {
            boolean isEmpty = ak.a.a.isEmpty();
            Log.e("vanda", "kill process unBindServiceIfIdle isEmpty = " + isEmpty + "  isIdle = " + n.a.c());
        }
        as.a();
        as.e();
    }
}
