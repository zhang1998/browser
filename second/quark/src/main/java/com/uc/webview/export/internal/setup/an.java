package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
final class an implements ValueCallback<k> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ am d;

    an(am amVar, Context context, String str, ValueCallback valueCallback) {
        this.d = amVar;
        this.a = context;
        this.b = str;
        this.c = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (!k.a(this.a)) {
            ((s) ((s) ((s) ((s) ((s) am.a(null).invoke(10001, this.d)).setup(UCCore.OPTION_CONTEXT, this.a)).setup(UCCore.OPTION_UCM_ZIP_FILE, this.b)).onEvent("stat", new ap(this))).onEvent("setup", new ao(this))).start();
        }
    }
}
