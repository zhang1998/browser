package com.taobao.weex.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.taobao.weex.bridge.c;

/* compiled from: ProGuard */
final class d implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ String b;
    final /* synthetic */ h c;

    d(h hVar, c cVar, String str) {
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
