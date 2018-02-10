package com.uc.quark.filedownloader.services;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class o implements ValueCallback {
    final /* synthetic */ ae a;

    o(ae aeVar) {
        this.a = aeVar;
    }

    public final void onReceiveValue(Object obj) {
        this.a.m = ((Integer) obj).intValue();
        this.a.a((byte) 7, this.a.l, null);
    }
}
