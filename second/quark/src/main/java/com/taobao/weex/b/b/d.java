package com.taobao.weex.b.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: ProGuard */
public final class d implements OnCancelListener {
    final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a(false, null);
    }
}
