package com.tencent.connect.b;

import android.app.Dialog;
import android.view.View;

/* compiled from: ProGuard */
final class b extends d {
    final /* synthetic */ e a;
    private final /* synthetic */ com.tencent.tauth.b d;
    private final /* synthetic */ Object e;

    b(e eVar, Dialog dialog, com.tencent.tauth.b bVar, Object obj) {
        this.a = eVar;
        this.d = bVar;
        this.e = obj;
        super(eVar, dialog);
    }

    public final void onClick(View view) {
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
        if (this.d != null) {
            this.d.a(this.e);
        }
    }
}
