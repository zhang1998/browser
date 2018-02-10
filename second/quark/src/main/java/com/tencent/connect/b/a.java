package com.tencent.connect.b;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.tencent.a.b.e;
import com.tencent.tauth.b;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class a extends d {
    final /* synthetic */ e a;
    private final /* synthetic */ b d;
    private final /* synthetic */ Object e;

    a(e eVar, Dialog dialog, b bVar, Object obj) {
        this.a = eVar;
        this.d = bVar;
        this.e = obj;
        super(eVar, dialog);
    }

    public final void onClick(View view) {
        e eVar = this.a;
        Bundle a = f.a(eVar.b);
        Activity activity = (Activity) eVar.b.j.get();
        if (activity != null) {
            new e(eVar.b.c, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", a, SpdyRequest.POST_METHOD).start();
        }
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
        if (this.d != null) {
            this.d.a(this.e);
        }
    }
}
