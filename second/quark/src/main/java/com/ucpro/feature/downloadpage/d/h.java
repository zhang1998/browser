package com.ucpro.feature.downloadpage.d;

import android.webkit.ValueCallback;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ v a;

    h(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        Object obj;
        ValueCallback valueCallback = this.a.c;
        if (this.a.a != null) {
            obj = this.a.a;
        } else {
            obj = new ArrayList();
        }
        valueCallback.onReceiveValue(obj);
    }
}
