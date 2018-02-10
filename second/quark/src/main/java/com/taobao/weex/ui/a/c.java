package com.taobao.weex.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProGuard */
final class c implements OnClickListener {
    final /* synthetic */ com.taobao.weex.bridge.c a;
    final /* synthetic */ String b;
    final /* synthetic */ h c;

    c(h hVar, com.taobao.weex.bridge.c cVar, String str) {
        this.c = hVar;
        this.a = cVar;
        this.b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }
}
